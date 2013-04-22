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

{template .Payment.Main}
	{meta override=true}
	<form id="payment-form" class="page-payment-main page-checkout-main" onsubmit="return false;" action="javascript:void(0);">
		<section class="cbox">
			<span class="highlights">{NLS('Page::Checkout::StandardShop::Payment')}</span>
			{Call .CheckoutSteps}
				{param tab='payment'}
			{/Call}

			<section class="payment-section">
					{call .Payment.Options}
			</section>
		</section>
		<section class="page-addresses-proceed page-checkout-proceed">
			{call .SSLInfo}
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

		<span class="highlights">{NLS('Page::Checkout::StandardShop::Payment')}</span>

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

