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

{template .Verification.Layout}
		{meta override=true}
        {call Structure.Layout.Fullwidth}
{/template}

{template .Payment.Options}
	{meta override=true}
	{* Show only paypal as the default customer method *}
	{call .Payment.PaypalBox}

{/template}

