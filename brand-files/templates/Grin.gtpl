{namespace Frameset}


{**
	By now, this template is active on all GRIN-Brands. It is linked via <BRAND>TEMPLINK.gtpl to the other branddirectories.
	Plz mind that every change applies to all GRIN-Brands!
**}

{template .Meta}
	{meta override=true}
	{*Grin specific global meta tags*}
	<link rel="apple-touch-icon" href="{OPTION('base-href-images')}commons/{GrinEnv.brand}-ios-icon.png"/>
{/template}

{template .Css}
	{meta override=true}
	{load_css_group('whitelabel.css')}
	{load_brand_css('grin-custom.css','grin-frameset.css')}
{/template}

{*
*
* .Top Template
*
*}
{template .Top}
	{meta override=true}
	{if (GrinEnv.i_am_hausarbeiten || GrinEnv.i_am_diplomarbeiten24) && !GrinEnv.i_am_ie6 && ! (GrinEnv.handler == 'document' && GrinEnv.i_am_diplomarbeiten24)}
		<div style="height: 90px; width: 0px; clear: both; float: none; display: block;"></div>
	{/if}

	<div class="header">
		<div class="identity">
			<!--<a href="{OPTION('base-href-main')}">
				{brand_img('grin-logo-de.png',null,null)}
				{*  NEW Logo - Needs to be implemented 
				<img src="{OPTION('base-href-images')}{GrinEnv.brand}/{GrinEnv.brand}-logo{if GrinEnv.i_am_grin}-{GrinEnv.lang}{/if}.png"
					 {if GrinEnv.i_am_hausarbeiten}
						 width="274px" height="44px"
					 {elseif GrinEnv.i_am_diplomarbeiten}
						 width="299px" height="44px"
					 {elseif GrinEnv.i_am_unterweisungen}
						 width="316px" height="45px"
					 {else}
						 width="220px" height="60px"
					 {/if}
					 /> *}-->
				{NLS('Help::Customer::CompanyName')}
			</a>
		</div>
		<div class="search">
				{Call Structure.SearchForm.Main}
					{if GrinEnv.i_am_hausarbeiten}
						{param placeholdertext=NLS('Page::Search::AllAndFreeTexts', 
							{alltexts: format_number(_ctx.brand_statistics.document_count), 
							freetexts: format_number(_ctx.brand_statistics.free_document_count)}
						)}
					{else}
						{param placeholdertext=NLS('Page::Search::AllTexts', 
							{alltexts: format_number(_ctx.brand_statistics.document_count)})}
					{/if}
				{/Call}
			</div>
		{call Widget.UserInfo.Container}
	</div>
	{* Menu *}
	<!--Not needed in this Template-->
	<!--<div class="nav">
		<div class="main-menu">
			<ul>
				{if RegExp("^\/[a-z]{2}\/$").test(GrinEnv.request_full_path)}
                <li class="nav_left_on"
        		{else}
                <li class="nav_left"
        		{/if}>
				<a href="{OPTION('base-href-main')}">{NLS('Page::Menu::Home')}</a> 
				{if RegExp("^\/[a-z]{2}\/$").test(GrinEnv.request_full_path)}
                <div class="arrow-bottom-on"
        		{else}
                <div class="arrow-bottom"
        		{/if}>
				</div>
				</li>
					{if RegExp("^\/[a-z]{2}\/upload$").test(GrinEnv.request_full_path)}
                	<li class="nav_main_on"
        			{else}
                	<li class="nav_main"
        			{/if}>
					{link_to(NLS('Page::Commons::BecomeAnAuthor'),OPTION('base-href-upload',{lang:GrinEnv.lang}))}
					{if RegExp("^\/[a-z]{2}\/upload$").test(GrinEnv.request_full_path)}
                	<div class="arrow-bottom-on"
        			{else}
                	<div class="arrow-bottom"
        			{/if}>
					</div>
				</li> 
					{if RegExp("^\/[a-z]{2}\/catalog\/$").test(GrinEnv.request_full_path)}
                	<li class="nav_main_on"
        			{else}
                	<li class="nav_main"
        			{/if}>
					<a href="{OPTION('base-href-main')}{GrinEnv.lang}/catalog/">{NLS('Page::Menu::Catalogue')}</a>
					{if RegExp("^\/[a-z]{2}\/catalog\/$").test(GrinEnv.request_full_path)}
                	<div class="arrow-bottom-on"
        			{else}
                	<div class="arrow-bottom"
        			{/if}> 
					</div>
				</li>
				{if GrinEnv.i_am_hausarbeiten}

				{else}
					{* Network 
					<li class="nav_main">
						<a href="{OPTION('base-href-network')}">{NLS('Page::Menu::People')}</a>
						<div class="arrow-bottom"></div>
					</li>
					*}
						{if RegExp("\/[a-z]{2}\/help").test(GrinEnv.request_full_path)}
	                	<li class="nav_main_on"
	        			{else}
	                	<li class="nav_main"
	        			{/if}>
						<a href="{OPTION('base-href-main')}{GrinEnv.lang}/help/author">{NLS('Page::Menu::Help')}</a>
						{if RegExp("\/[a-z]{2}\/help").test(GrinEnv.request_full_path)}
                		<div class="arrow-bottom-on"
        				{else}
                		<div class="arrow-bottom"
        				{/if}></div>
					</li>
				{/if}
			</ul>
		</div>
		<div class="nav_bg">
			
			<div class="header-items">
				<a href="{OPTION('base-href-blog')}">{NLS('Page::Menu::Blog')}</a>
			</div>
			<div class="header-items">
				{link_to(brand_img('grin_twitter.png',null,'grin-twitter-fb'),'http://www.twitter.com/grin_com',null,{target:'_blank'})}
			</div>
			<div class="header-items-images">
				{link_to(brand_img('grin_fb.png',null,'grin-twitter-fb'),'http://www.facebook.com/grincom',null,{target: '_blank'})}
			</div>
		</div>
		<div class="nav_right">
		</div>
		{*    Upload - button disabled
		<div class="color-white upload-area-position upload-area">
			<a href="{OPTION('base-href-upload',{lang:GrinEnv.lang})}" class="upload-area-caption cursor-pointer">{NLS('Page::Upload::WebartsLongMessage')}</a>
		</div>  *}
	</div>
-->
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
				<li>{NLS('Help::StandardShop::CompanyName')}</li>
				<li>{NLS('Help::StandardShop::Street')}</li>
				<li>{NLS('Help::StandardShop::PLZ')}{NLS('Help::Customer::Town')}</li>
				<li>{NLS('Help::StandardShop::Telephon')}{NLS('Help::Customer::Telephonenumber')}</li>
				<li>{NLS('Help::StandardShop::Mail')}{NLS('Help::Customer::Mailto')}</li>
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
		<!--<div class="column-big">
			{NLS('Page::Footer::AboutGRIN')}
			<div class="social-buttons">
				{NLS('Page::Footer::RecommendGRIN')}
				{link_to(brand_img('grin_gplus.png',null,null),'https://plus.google.com/u/0/104119599352556600480/',null,{target: '_blank'})}
				{link_to(brand_img('grin_fb.png',null,null),'http://www.facebook.com/grincom',null,{target: '_blank'})}
				{link_to(brand_img('grin_twitter.png',null,null),'http://www.twitter.com/grin_com',null,{target:'_blank'})}
			</div>
		</div>-->
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

	{if !GrinEnv.i_am_grin && !GrinEnv.i_am_unterweisungen && !(GrinEnv.handler == 'document' && GrinEnv.i_am_diplomarbeiten24)}
		{call .Advertisement}
	{/if}

	{call .VGWORT}
{/template}

{template .VGWORT}

	{if GrinEnv.handler == 'document'}
		{if _ctx.maindata.identifiers && _ctx.maindata.identifiers.vgwort && _ctx.maindata.identifiers.vgwort.publicidentificationid}
			<img width="1" height="1" alt="" src="http://vg00.met.vgwort.de/na/{_ctx.maindata.identifiers.vgwort.publicidentificationid}"></img>
		{/if}
	{/if}

{/template}

{template .Advertisement}
<!--	<iframe style="position:absolute; left:0px; top:0px; width: 1190px; height:717px; outline: medium none; border: medium none; background: none" 
		scrolling="no" 
		frameborder="0" 
		allowtransparency="true"
		src="{OPTION('base-href-ad-mirror')}?brand={GrinEnv.brand}&amp;areas=banner;skyscraper&amp;hostpage={GrinEnv.handler}&amp;sector={get_sector(_ctx.maindata) || ''}"
	>
	</iframe>-->
{/template}


{*
*
* Container Template called on OrderFinished page
*
*}
{template .OrderFinished.InfoBox}
	{param account=_ctx.maindata}
	{if (GrinEnv.i_am_grin || GrinEnv.i_am_hausarbeiten) && GrinEnv.lang == 'de'}
		{param shop_id=GrinEnv.i_am_grin ? 'X1098E55B93A58BF003CB4E90E5AF4E73' : 'X3E9B44D7C191BAEC3BC114194FEC381F'}

		<div class="sub-section top-line">
			<!-- trusted shops form -->
			{literal}
				<style>
					table.tform { border: none;  }
					table.tform td { border: none; }
					table.tform tr:hover { background: none; }
				</style>
			{/literal}
			<table border="0" cellspacing="0" cellpadding="4" class="tform">
				<tr>
					<td width="90">
						<form name="formSiegel" method="post" action="https://www.trustedshops.com/shop/certificate.php" target="_blank">
							<input type="image" border="0" src="/images/trustedshops_m.gif" title="Trusted Shops Gütesiegel - Bitte hier Gültigkeit prüfen!" style="width: 63px; height: 60px; border: none; box-shadow: none;"/>
							<input name="shop_id" type="hidden" value="{_p.shop_id}" />
						</form>
					</td>
					<td align="justify">
						<form id="formTShops" name="formTShops" method="post" action="https://www.trustedshops.com/shop/protection.php" target="_blank">
							<input name="_charset_" type="hidden" value="" />
							<input name="shop_id" type="hidden" value="{_p.shop_id}" />
							<input name="email" type="hidden" value="{_p.account.shopping_cart.email}" />
							<input name="amount" type="hidden" value="{_p.account.sum_gross[0].value / 100}" />
							<input name="curr" type="hidden" value="{_p.account.sum_gross[0].currency}" />
							<input name="paymentType" type="hidden" value="{_p.account.shopping_cart.payment_type}" />
							<input name="KDNR" type="hidden" value="a{_p.account.user_id}" />
							<input name="ORDERNR" type="hidden" value="{_p.account.invoice.transaction_id}" />
							Als zusätzlichen Service bieten wir Ihnen den Trusted Shops Käuferschutz an. Wir übernehmen alle Kosten dieser Garantie, Sie müssen sich lediglich anmelden.
							<br />
							<br />
							<button type="submit" id="btnProtect" name="btnProtect" class="m-5px-left">
								<span><span>Anmeldung zum Trusted Shops Käuferschutz</span></span>
							</button>
						</form>
					</td>
				</tr>
			</table> 
		</div>
	{/if}

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