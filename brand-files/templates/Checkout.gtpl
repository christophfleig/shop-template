{namespace Page.Checkout}

{template .Shoppingcart.Heading}
	{meta override=true}
{/template}

{template .Shoppingcart.Layout}
	{meta override=true}
	{call Structure.Layout.Fullwidth}
{/template}

{template .Shoppingcart.Main}
	{meta override=true}
	{if !_.document_transactions.length}
		{call .Shoppingcart.Empty}
	{else}
		<section class="page-shoppingcart-main page-checkout-main cbox meta">
			{*{Call Widget.BreadCrumbs.Main}
      			{param link_last_item=true}
    		{/Call}*}
			{call .SSLInfo}
			<h2 class="heading1">{NLS('Page::ShoppingCart::Title')}</h2>
			<section class="overview">
				{call .Shoppingcart.Overview}
			</section>
			<section class="shoppingcart-items">
				{call .Shoppingcart.Items}
			</section>
			<section class="totals">
				{call .Shoppingcart.Totals}
			</section>
			<section class="disclaimers">
				{call .Shoppingcart.Disclaimers}
			</section>
			<section class="page-shoppingcart-proceed page-checkout-proceed">
				<a class="call-to-action" href="{OPTION('base-href-checkout-addresses')}">
					<span class="button-text">{NLS('Page::Commons::StartCheckout')}</span>
					<!--<span class="button-icon"></span>-->
				</a>
			</section>
		</section>


	{/if}
{/template}

{template .Shoppingcart.Items}
	{meta override=true}
	<ul>
		{foreach item in _.document_transactions}
			<li class="shoppingcart-item">
				<div class="picturebox">
					<a  href="{item.product.object.grin_url}" class="poi" grin:poi="CLICK_PRODUCT_IN_SHOPPINGCART">
						{picture(item.product.object, 'related')}
					</a>
				</div>

				<div class="meta">
					<h4 class="heading1">
						<a href="{item.product.object.grin_url}" class="poi" 
							grin:poi="CLICK_PRODUCT_IN_SHOPPINGCART">
							{item.product.object.title}
						</a>
					</h4>

					{Call .Shoppingcart.ItemForms root=item}
						{param account_id=_._id}
					{/Call}

					<div class="price-calculation">
						{if item.quantity > 1}
							<span class="quantity-calculation">
								{item.quantity} x {NLS('orderitem::ebook')}{item.amount_gross.formatted} = 
							</span>
						{/if}
						<span class="sum">{item.sum_gross.formatted}</span>
					</div>
				</div>
			</li>
		{/foreach}
	</ul>
{/template}

{template .Payment.Main}
	{meta override=true}
	<form id="payment-form" class="page-payment-main page-checkout-main" onsubmit="return false;" action="javascript:void(0);">
		<section class="cbox">
			{*{Call Widget.BreadCrumbs.Main}
      			{param link_last_item=true}
    		{/Call}*}
			{call .SSLInfo}
			{Call .CheckoutSteps}
				{param tab='payment'}
			{/Call}

			<section class="payment-section">
					{call .Payment.Options}
			</section>
		</section>
		<section class="page-addresses-proceed page-checkout-proceed">
			<button class="call-to-action" type="submit" id="payment-trigger">
				<span class="button-text">{NLS('Page::Checkout::ContinueCheckout')}</span>
				<span class="button-icon"></span>
			</button>
		</section>
	</form>
{/template}

{template .Payment.Layout}
		{meta override=true}
        {call Structure.Layout.Fullwidth}
{/template}

{template .Payment.Options}
	{meta override=true}
	{* Show only paypal as the default customer method *}
	{call .Payment.PaypalBox}
{/template}

{template .Verification.Main}
	{meta override=true}
	{param use_invoice_address=_.shopping_cart.invoice_address && _.shopping_cart.invoice_address.use_invoice_address == 'YES'}

	<section class="page-verification-main page-checkout-main cbox">
		{*{Call Widget.BreadCrumbs.Main}
      	{param link_last_item=true}
    	{/Call}*}
		{Call .CheckoutSteps}
			{param tab='verification'}
		{/Call}

		<section class="shoppingcart-items">
			{call .Verification.Items}
		</section>

		<section class="totals">
			{call .Shoppingcart.Totals}
		</section>		

		<section class="paymentmethod">
			{call .Verification.PaymentMethod}
		</section>

		<section class="disclaimers">
			{NLS('Page::ShoppingCart::RightOfWithdrawal')}
		</section>
	</section>

	<section class="page-verification-proceed page-checkout-proceed">
		<form id="verification-form" method="post" action="{OPTION('base-href-pay_order')}">
			<input type="hidden" name="account_id" value="{_._id}"/>
			{call .SSLInfo}
			<button class="call-to-action" type="submit" id="payment-trigger">
				<span class="button-text">{NLS('Page::Commons::ConfirmTheOrder')}</span>
				<span class="button-icon"></span>
			</button>
		</form>
	</section>
{/template}

{template .Verification.Layout}
		{meta override=true}
        {call Structure.Layout.Fullwidth}
{/template}

{template .Verification.PaymentMethod}
{meta override=true}
	<span class="highlights">{NLS('Page::Checkout::PaymentDetails')}</span>
	<p class="meta">
		{if _.shopping_cart.payment_type == 'BANKACCOUNT'}
			<b class="method">{NLS('Page::Checkout::Debit')}</b>
			<br/>
			{NLS('Page::EditAccountDetails::AccountHolder')}:&nbsp;{_.shopping_cart.payment_data_bankaccount.holder} <br/>
			{NLS('Page::Commons::AccountNumber')}: &nbsp;{_.shopping_cart.payment_data_bankaccount.de_number} 
			<br/>
			{NLS('Page::Commons::BankCode')}:&nbsp;{_.shopping_cart.payment_data_bankaccount.de_bank_code}
		{elseif _.shopping_cart.payment_type == 'CREDITCARD'}
			<b class="method">{NLS('Page::Checkout::CreditCard')}</b>
			<br/>
			{if _.shopping_cart.payment_data_creditcard.type == 'VISA'}
				Visa
			{elseif _.shopping_cart.payment_data_creditcard.type == 'MASTERCARD'}
				MasterCard
			{else}
				American Express
			{/if}
			<br/>
			{_.shopping_cart.payment_data_creditcard.truncated_card_pan}
		{elseif _.shopping_cart.payment_type == 'PAYPAL'}
			{img('/commons/logo-paypal.gif')}
			<br/>
			{NLS('Page::Checkout::PaypalLongInfo')}
		{elseif _.shopping_cart.payment_type == 'CLICKANDBUY'}
			{img('/commons/logo-clickandbuy.gif')}
			<br/>
			{NLS('Page::Checkout::ClickandBuyLongInfo')}
		{/if}
	</p>
	<a href="{OPTION('base-href-checkout-payment')}" class="changelink poi" grin:poi="PAYMENT_CLICK_CHANGE_PAYMENTMETHOD">{NLS('Page::Commons::Change')}</a>
{/template}

{template .CheckoutSteps}
{meta override=true}
	{param current_step = 0}

	<nav class="checkout-steps">
	<span class="highlights">{NLS('Page::Checkout::StandardShop::Payment')}</span>
		{if _.shopping_cart.needs_shipping_address}
			{if _p.tab=='address'}
				<div class="checkout-step shipping-address selected">
					<span class="step-no">{++_p.current_step}</span>
					<span class="step-name">{NLS('Page::ShoppingCart::YourShippingAddress')}</span>
				</div>
			{else}
				<a href="{OPTION('base-href-checkout-addresses')}" class="checkout-step shipping-address">
					<span class="step-no">{++_p.current_step}</span>
					<span class="step-name">{NLS('Page::ShoppingCart::YourShippingAddress')}</span>
				</a>
			{/if}
		{/if}

		{if _p.tab == 'address'}
			<div class="checkout-step payment">
				<span class="step-no">{++_p.current_step}</span>
				<span class="step-name">{NLS('Page::Checkout::ChoosePaymentMethod')}</span>
			</div>
		{elseif _p.tab == 'payment'}
			<div class="checkout-step payment selected">
				<span class="step-no">{++_p.current_step}</span>
				<span class="step-name">{NLS('Page::Checkout::ChoosePaymentMethod')}</span>
			</div>
		{elseif _p.tab=='verification'}
			<a href="{OPTION('base-href-checkout-payment')}" class="checkout-step payment">
				<span class="step-no">{++_p.current_step}</span>
				<span class="step-name">{NLS('Page::Checkout::ChoosePaymentMethod')}</span>
			</a>
		{/if}

		{if _p.tab == 'verification'}
			<div class="checkout-step verification selected">
				<span class="step-no">{++_p.current_step}</span>
				<span class="step-name">{NLS('Page::Checkout::VerifyOrder')}</span>
			</div>
		{else}
			<div class="checkout-step verification">
				<span class="step-no">{++_p.current_step}</span>
				<span class="step-name">{NLS('Page::Checkout::VerifyOrder')}</span>
			</div>
		{/if}
	</nav>
{/template}

{template .Verification.Items}
{meta override=true}
	<h3 class="heading1">{NLS('Page::ShoppingCart::Title')}</h3>
	<ul>
		{foreach item in _.document_transactions}
			<li class="shoppingcart-item">
				<div class="picturebox">
					{picture(item.product.object, 'thumb')}
				</div>

				<div class="meta">
					<div class="heading1">
						{item.product.object.title}
					</div>

					<div class="product-quantity">
						<b>{item.quantity}</b> x {NLS('orderitem::ebook')}{call .ShowType root=item.product}
					</div>

					<div class="price-calculation">
						{if item.quantity > 1}
							<span class="quantity-calculation">
								{item.quantity} x {NLS('orderitem::ebook')}{item.amount_gross.formatted} = 
							</span>
						{/if}
						<span class="sum">{item.sum_gross.formatted}</span>
					</div>
				</div>
			</li>
		{/foreach}
	</ul>
{/template}