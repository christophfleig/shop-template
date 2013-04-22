{namespace Frameset}


{**
	By now, this template is active on all GRIN-Brands. It is linked via <BRAND>TEMPLINK.gtpl to the other branddirectories.
	Plz mind that every change applies to all GRIN-Brands!
**}

{template .Css}
	{meta override=true}
	{load_css_group('whitelabel.css')}
	{load_brand_css('grin-frameset.css')}
{/template}

{*
*
* .Top Template
*
*}
{template .Top}
	{meta override=true}
	<div class="header">
	<div class="head-box">
		<div class="identity">
			<a href="{OPTION('base-href-main')}">
				{NLS('Help::Customer::CompanyName')}
			</a>
		</div>
		<div class="search">
				{Call Structure.SearchForm.Main}
						{param placeholdertext=NLS('Page::Search::AllTexts', 
						{alltexts: format_number(_ctx.brand_statistics.document_count)})}
				{/Call}
			</div>
		{call Widget.UserInfo.Container}
	</div>
	</div>
{/template}

{*
*
* SIDEBAR
*
*}
{template .Sidebar}
	{meta override=true}	
	{* No static sidebar *}
{/template}

{*
*
* FOOTER
*
*}
{template.Footer}
{meta override=true}	
	<div class="footer">
		<div class="column">
			<div class="footer-1st-element">{NLS('Page::Menu::About')}</div>
			<ul>
				<li>{link_to_static(NLS('Page::Menu::Blog'),'',null)}</li>
				<li>{link_to_static(NLS('Page::Menu::About::Team'),'',null)}</li>
				<li>{link_to_static(NLS('Page::StandardShop::About::Contact'),'',null)}</li>
				<li>{link_to_static(NLS('Page::StandardShop::About::Facebook'),'',null)}</li>
				<li>{link_to_static(NLS('Page::StandardShop::About::Twitter'),'',null)}</li>
			</ul>
		</div>
		<div class="column">
			<div class="footer-1st-element">{NLS('Page::StandardShop::Support')}</div>
			<ul>
				<li>{link_to_static(NLS('Help::StandardShop::UsersAndBuyers::FAQ'),'',null)}</li>
				<li>{link_to_static(NLS('Help::StandardShop::UsersAndBuyers::Section4::Headline'),'help/buyers#payment',null)}</li>
			</ul>
		</div>
		<div class="column">
			<div class="footer-1st-element">{NLS('Page::StandardShop::About::Contact')}</div>
			<ul>
				<li>{link_to_static(NLS('Help::StandardShop::CompanyName'),'',null)}</li>
				<li>{link_to_static(NLS('Help::StandardShop::Street'),'',null)}</li>
				<li>{link_to_static(NLS('Help::StandardShop::PLZ')}{NLS('Help::Customer::Town'),'',null)}</li>
				<li>{link_to_static(NLS('Help::StandardShop::Telephon')}{NLS('Help::Customer::Telephonenumber'),'',null)}</li>
				<li>{link_to_static(NLS('Help::StandardShop::Mail')}{NLS('Help::Customer::Mailto'),'',null)}</li>
			</ul>
		</div>
		<div class="column">
			<div class="footer-1st-element">{NLS('Help::StandardShop::CompanyName')}</div>
			<ul>
				<li>{link_to_static(NLS('Page::Imprint'),'contact.html',null)}</li>
				<li>{link_to_static(NLS('Page::Imprint::Privacy'),'privacy.html',null)}</li>
				<li>{link_to_static(NLS('Help::UsersAndBuyers::Section6::Headline'),'help/buyers#legal',null)}</li>
			</ul>
		</div>
		<div class="clear-all"></div>
	</div>
{/template}


{*
*
* BOTTOM
*
*}
{* .Bottom is called directly before </body></html> *}
{template .Bottom}
	{meta override=true}
{/template}

{*
*
* Container Template called on OrderFinished page
*
*}
{template .OrderFinished.InfoBox}
	{param account=_ctx.maindata}
	
	<!-- Google Code for Purchase/Sale Conversion Page ACCOUNT 1 -->
	<script type="text/javascript">
		<!-- /* <![CDATA[ */ -->
		var google_conversion_id = 1072502168;
		var google_conversion_language = "en";
		var google_conversion_format = "1";
		var google_conversion_color = "666666";
		var google_conversion_label = "purchase";
		var google_conversion_value = {_p.account.sum[0].value};
		<!-- /* ]]> */ -->
	</script>
	<script type="text/javascript" src="https://www.googleadservices.com/pagead/conversion.js">
	</script>
	<noscript>
		<div style="display:inline;">
			<img height="1" width="1" style="border-style:none;" alt="" src="https://www.googleadservices.com/pagead/conversion/1072502168/?label=purchase&amp;guid=ON&amp;script=0"/>
		</div>
	</noscript>

	<!-- Google Code for Purchase/Sale Conversion Page ACCOUNT 2-->
	<script type="text/javascript">
		<!-- /* <![CDATA[ */ -->
		var google_conversion_id = 979605176;
		var google_conversion_language = "de";
		var google_conversion_format = "2";
		var google_conversion_color = "ffffff";
		var google_conversion_label = "BMbLCKj9wQIQuK2O0wM";
		var google_conversion_value = {_p.account.sum[0].value};
		<!-- /* ]]> */ -->
	</script>
	<script type="text/javascript" src="https://www.googleadservices.com/pagead/conversion.js">
	</script>
	<noscript>
		<div style="display:inline;">
			<img height="1" width="1" style="border-style:none;" alt="" src="https://www.googleadservices.com/pagead/conversion/979605176/?label=BMbLCKj9wQIQuK2O0wM&amp;guid=ON&amp;script=0"/>
		</div>
	</noscript>
{/template}