{namespace Page.Checkout}

{template .Payment.Options}
	{meta override=true}

	{* Bank, only in EUR-zone *}
	{if GrinEnv.currency == 'EUR'}
		{call .Payment.BankaccountBox}
	{/if}
	{call .Payment.CreditcardBox}
	{call .Payment.PaypalBox}
	{call .Payment.ClickandBuyBox}
{/template}

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
			<section class="page-shoppingcart-proceed page-checkout-proceed">
				<a class="call-to-action" href="{OPTION('base-href-checkout-addresses')}">
					<span class="button-text">{NLS('Page::Commons::StartCheckout')}</span>
					<!--<span class="button-icon"></span>-->
				</a>
			</section>
			<section class="disclaimers">
				{call .Shoppingcart.Disclaimers}
			</section>
		</section>


	{/if}
{/template}


