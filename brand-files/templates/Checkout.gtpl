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
	{* Show only paypal as the default customer method *}
	{call .Payment.PaypalBox}

{/template}

{template .Payment.PaypalBox}
	{* PAYPAL *}
	<div class="payment-method paypal radio-fold">
		<div class="overview input-area">
			<input type="radio" value="PAYPAL" name="payment_type" class="radio-fold-trigger" {if _.shopping_cart.payment_type == 'PAYPAL'}checked="checked"{/if}/>
			<b class="heading1">Paypal</b>
			{img('commons/logo-paypal.gif')}
			<p class="info">{NLS('Page::ShoppingCart::PaypalShortInfoWebArts')}</p>
		</div>
		<fieldset id="paypaldetails" class="details radio-fold-container" {if _.shopping_cart.payment_type != 'PAYPAL'}style="display:none;"{/if}>
			<p class="longinfo">{NLS('Page::Checkout::PaypalLongInfo')}</p>
			{Call .Payment.InvoiceAddressForm}
				{param payment_type='paypal'}
			{/Call}
		</fieldset>
	</div>
{/template}

{template .Payment.InvoiceAddressForm}
	{param user_shipping_address=_.shopping_cart.user_shipping_address || {}}
	{param invoice_address=_.shopping_cart.invoice_address || {}}
	{param show_form=_p.invoice_address.use_invoice_address == 'YES'}
	
	<section class="invoiceaddress foldable {if _p.show_form}unfolded{/if}">
		<div class="invoiceaddress-info">
			<input type="checkbox" value="true" class="foldable-trigger {if _p.show_form}unfolded-trigger{/if} poi" name="add_invoice_address" id="{_p.payment_type}-add_invoice_address" {if _p.show_form}checked="checked"{/if} grin:datatype="boolean" grin:poi="PAYMENT_CLICK_ADD_INVOICEADDRESS"/>
			<label for="{_p.payment_type}-add_invoice_address">{NLS('Page::ShoppingCart::AddInvoiceAddress')}</label>
			<div class="hint hint-icon bla">
				<div class="hint-text">
					{NLS('Page::ShoppingCart::InvoiceAddressInfoBall')}
				</div>
			</div>
		</div>
		<div class="invoiceaddress-fields foldable-container {if _p.show_form}unfolded-container{/if}" grin:slide="no">
			<b class="heading1">{NLS('Page::Commons::InvoiceAddress')}</b>
			<p class="info">{NLS('Page::ShoppingCart::InvoiceAddressInfo')}</p>

			<div class="form-row compact academic_title">
				<label for="academic_title" >{NLS('Page::Commons::AcademicTitle')}</label>
				<input type="text" id="invoice_address_academic_title" value="{_p.invoice_address.academic_title || _p.user_shipping_address.academic_title || ''}" name="invoice_address_academic_title"/>
			</div>
			<div class="form-row compact invoice_address_first_name">
				<label for="invoice_address_first_name" >{NLS('Page::Commons::Name')} *</label>
				<input type="text" id="invoice_address_first_name" value="{_p.invoice_address.first_name || _.shopping_cart.first_name || _p.user_shipping_address.first_name || ''}" name="invoice_address_first_name"/>
			</div>
			<div class="form-row compact invoice_address_last_name">
				<label for="invoice_address_last_name" >{NLS('Page::Commons::LastName')} *</label>
				<input type="text" id="invoice_address_last_name" value="{_p.invoice_address.last_name || _.shopping_cart.last_name || _p.user_shipping_address.last_name || ''}" name="invoice_address_last_name"/>
			</div>
			<div class="form-row compact invoice_address_company">
				<label for="invoice_address_company" >{NLS('Page::Commons::CompInstitution')}</label>
				<input type="text" id="invoice_address_company" value="{_p.invoice_address.company || _p.user_shipping_address.line2 || ''}" name="invoice_address_company"/>
			</div>
			<div class="form-row compact invoice_address_street">
				<label for="invoice_address_street" >{NLS('Page::Commons::Street')} *</label>
				<input type="text" id="invoice_address_street" value="{_p.invoice_address.street || _p.user_shipping_address.street || ''}" name="invoice_address_street"/>
			</div>
			<div class="form-row compact invoice_address_zip">
				<label for="invoice_address_zip" >{NLS('Page::Commons::ZipCode')} *</label>
				<input type="text" id="invoice_address_zip" value="{_p.invoice_address.zip || _p.user_shipping_address.zip || ''}" name="invoice_address_zip"/>
			</div>
			<div class="form-row compact invoice_address_city">
				<label for="invoice_address_city" >{NLS('Page::Commons::Town')} *</label>
				<input type="text" id="invoice_address_city" value="{_p.invoice_address.city || _p.user_shipping_address.city || ''}" name="invoice_address_city"/>
			</div>
			<div class="form-row compact invoice_address_country_id">
				<label for="invoice_address_country_id" >{NLS('Page::Commons::Country')} *</label>
				<select id="invoice_address_country_id" name="invoice_address_country_id" grin:datatype="number" autocomplete="off">
					{call Widget.CountryOptions root=_p.invoice_address.country_id || _p.user_shipping_address.country_id || _.shopping_cart.user_country_id} 
				</select>
			</div>
		</div>
	</section>
{/template}