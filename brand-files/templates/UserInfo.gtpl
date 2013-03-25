{namespace Widget.UserInfo}

{template .Container}
	{meta override=true}
	<div id="userinfo" class="grineditor" grin:editor="Gtpl_Editor" grin:template="Widget.UserInfo.Main" grin:template-namespaces="Widget.UserInfo" grin:redraw="no" grin:nofx="yes" grin:skip_first_draw="yes">
		{call .Main}
	</div>
{/template}

{template .AdminMenu}
	{meta override=true}
	<div class="admin-menu">
		<div class="grineditor with-inner-shadow with-border-dark bg-white drop-down-arrow  top-dropdown-menu" 
			grin:editor="Gtpl_Editor"
			grin:template="Admin.Widget.UserInfo.AdminUserInfo" 
			grin:template-namespaces="Admin.Widget.UserInfo" 
			grin:lang-namespaces="admin_comments" 
			{if GrinEnv.i_am_server}grin:skip_first_draw="yes"{/if}>
			{if GrinEnv.i_am_server}
				{call Admin.Widget.UserInfo.AdminUserInfo}
			{/if}
		</div>
	</div>
{/template}

{template .AdminUpgrade}
	{meta allow_override=true}
	<div class="admin-menu">
		<div class="require-admin"><a href="javascript:void(0);">Upgrade...</a></div>
	</div>
{/template}

{template .AdminButton}
	{meta override=true}
	{if login().admin_priv}
		{if login().is_admin}
			{call .AdminMenu}
		{elseif OPTION('require-admin-cookie') == 'yes'}
			{call .AdminUpgrade}
		{/if}
	{/if}
{/template}

{template .LoginButton}
	{meta override=true}
	{link_to_login(NLS('web::www.grin.com::Page::UserInfo::LogIn'),'index',null,'login-trigger')}
{/template}

{template .LanguageTrigger}
	{meta override=true}
	<span id="language-select-span" class="top-dropdown-menu with-inner-shadow with-border-dark bg-white w80px drop-down-arrow" style="left: 80px;"> 
		<a href="javascript:void(0);" id="language-select-trigger">{ENLS('languages',GrinEnv.language_id)}</a>
		<ul id="language-selector" style="display:none;">
			{if GrinEnv.lang !== 'de'}
				<li><a href="javascript:void(0);" data-grin-lang="de">Deutsch</a></li>
			{/if}
			{if GrinEnv.lang !== 'en'}
				<li><a href="javascript:void(0);" data-grin-lang="en">Englisch</a></li>
			{/if}
			{if GrinEnv.lang !== 'es'}
				<li><a href="javascript:void(0);" data-grin-lang="es">Español</a></li>
			{/if}
			{if GrinEnv.lang !== 'fr'}
				<li><a href="javascript:void(0);" data-grin-lang="fr">Français</a></li>
			{/if}
		</ul>
	</span>
{/template}

{template .ShoppingCart}
	{meta override=true}
	{if login().shoppingcart_account}
		<a href="{OPTION('base-href-shoppingcart')}" class="top-shopping-cart with-small-rounded-corners">
	{else}
		<div class="top-shopping-cart with-small-rounded-corners" style="cursor:default;">
	{/if}
	<span class="shopping-cart-info">
		<span class="p5px-right" style="display: block;">
			{if login().shoppingcart_account}
				{login().shoppingcart_account.document_transactions.length} {if login().shoppingcart_account.document_transactions.length == 1}{NLS('web::www.grin.com::Page::Sidebar::ShoppingCart::Item')}{else}{NLS('web::www.grin.com::Page::Sidebar::ShoppingCart::Items')}{/if}&#160;|&#160;<b>{login().shoppingcart_account.sum_gross[0].formatted}</b>
			{else}
				<span class="wk-link"><a href="{OPTION('base-href-shoppingcart')}">{NLS('Page::ShoppingCart::Title')}</a></span>
				0 {NLS('web::www.grin.com::Page::Sidebar::ShoppingCart::Items')}&#160;|&#160;{zero_amount()}
			{/if}<br/>
		</span> 
	</span> 
	{if login().shoppingcart_account}
		</a>
	{else}
		</div>
	{/if}
{/template}

{template .UserMenuDropdown}
	{meta override=true}
	{if login().user_realm_id != GrinEnv.realm_id}
		{call .UserInfo.UserMenuOtherRealm root=_ }

	{elseif OPTION('admin-feature-set') == 'full'}
		{call .UserInfo.UserMenu root=_ }

	{else}
		{call .UserInfo.UserMenuBasic root=_ }
	{/if}
{/template}


{template .Main}
	{meta allow_override=true}
	<div class="top-info">
		{if GrinEnv.i_am_grin || GrinEnv.i_am_hausarbeiten}
			<a class="etrusted" href="{if GrinEnv.brand == 'hausarbeiten'}{OPTION('base-href-main')}help/buyers#buying-paying{else}{OPTION('base-href-main')}{GrinEnv.lang}/help/buyers#buying-paying{/if}">
				{brand_img('trusted-shops.png',null,'etrusted-logo')}
			</a>
		{/if}

		{call .AdminButton}

		{call .ShoppingCart}

		<div class="user-info">
			{if GrinEnv.i_am_grin} {* change later *}
				{call .LanguageTrigger}
			{elseif !GrinEnv.i_am_hausarbeiten && login().auth_method == 'NONE'}
				<div style="position: absolute; top: 0px; left: 80px; display: block;">
					<a href="http://www.grin.com/" title="{NLS('Page::Commons::Claim')}">
						<img class="" src="{OPTION('base-href-images')}commons/small-grin.png" alt="{NLS('Page::Commons::Claim')}"/>
					</a>
				</div>
			{/if}

			{if login().auth_method != 'NONE'}
				{call .UserMenuDropdown}
			{else}
				<span class="top-login m2px-top" style="right: -30px;">
					{call .LoginButton}
				</span>
			{/if}
		</div>
	</div>
{/template}

{* When grin administrators are logged in into wrong realm, they won't see anything *}
{template .UserInfo.UserMenuOtherRealm}
	{meta override=true}
        <div class="top-login top-dropdown-menu with-inner-shadow with-border-dark bg-white drop-down-arrow">
            {truncate_string(login().screenname_ext,57)} 
            <ul class="user-account-dropdown">
                <li>{link_to_login(NLS('Page::UserInfo::LogOut'),'logout',null,'logout-trigger')}</li>
            </ul>
        </div>
{/template}

{template Admin.Widget.UserInfo.AdminUserInfo}
	{meta allow_override=true}
	{if OPTION('admin-feature-set') == 'full'}
		{call Admin.Widget.UserInfo.AdminUserInfoFull}
	{else}
		{call Admin.Widget.UserInfo.AdminUserInfoBasic}
	{/if}
{/template}

{template Admin.Widget.UserInfo.AdminUserInfoFull}
	{meta override=true}
	{link_to_login('Admin',['admin','index'],null,'dropdown')}
	<ul>
		{if OPTION('require-admin-cookie') == 'yes'}
			<li class="require-noadmin"><a href="javascript:void(0);">Downgrade...</a></li>
		{/if}
		<li>{link_to_login('Admin-Home',           ['admin','index'])}</li>
		<li>{link_to_login('Admin-Suche',          ['admin','search','document'])}</li>
		<li>{link_to_login('Dashboard',['admin','integrity'])}</li>
		<li>{link_to_login('Cache Invalidierung',  ['admin','cache'])}</li>
		<li>{link_to_login('Jobs anstossen',       ['admin','job'])}</li>
		<li>{link_to_login('Kunde anlegen',        ['admin','user'])}</li>
		<li><hr/></li>
		<li>{link_to_login('Akquise',['admin','acquisition'])}</li>
		<li>{link_to_login('Endkontrolle'        ,['admin','integrity','document_wait_final_check'])}</li>
		<li>{link_to_login('Kommentare'     ,['admin','comments'])}</li>
		{if login().admin_groups.translation}
			<li>{link_to_login('Lang-DB'             ,['admin','lang'])}</li>
		{/if}
		<li><hr/></li>
		{if login().admin_groups.realm}
			<li>{link_to_login('Realm Config',['admin','realmconfig'])}</li>
			<li>{link_to_login('Realm Files',['admin','realmfiles'])}</li>
			<li>{link_to_login('Verlagsimpressum',['admin','realm_imprints'])}</li>
			<li>{link_to_login('Genre',['admin','realm_genres'])}</li>
			<li>{link_to_login('CMS',['admin','cms'])}</li>
			<li>{link_to_login('Sidebar',['admin','sidebar'])}</li>
			<li>{link_to_login('Blog',['admin','blog'])}</li>
			<hr/>
		{/if}
		<li>{link_to_login('External Book Verlage',['admin','external_book_publisher'])}</li>
		<li>{link_to_login('F&auml;cher',['admin','subjects'])}</li>
		<li>{link_to_login('Gruppen',['admin','groups'])}</li>
		{if login().admin_groups.institution}
			<li>{link_to_login('Hochschulen',['admin','institutions'])}</li>
		{/if}
		<li>{link_to_login('Kategorien',['admin','categories'])}</li>
		<li>{link_to_login('L&auml;nder',['admin','countries'])}</li>
		<li>{link_to_login('License Text',['admin','licensetext'])}</li>
		<li>{link_to_login('Preise',['admin','prices'])}</li>
		<li>{link_to_login('Sprachen',['admin','languages'])}</li>
		<li>{link_to_login('Themen',['admin','topic'])}</li>
		<li>{link_to_login('Ambassador',['admin','ambassador'])}</li>
		<li>{link_to_login('VLB Kategorien',['admin','vlb_kat'])}</li>
		{if login().is_superuser}
			<li><hr/></li>
			<li>{link_to_login('Reporting'           ,['admin','reporting'])}</li>
			<li>{link_to_login('Session Tracking'           ,['admin','sessiontracking'])}</li>
			<li>{link_to_login('Test Abrechnungen'   ,['admin','statement'])}</li>
		{/if}
	<li><hr/></li>
		<li>{link_to_login('USMARC-F&auml;cher' ,['admin','usmarc_subjects'])}</li>
		<li>{link_to_login('USMARC-Hochschulen'    ,['admin','usmarc_institutions'])}</li>
	</ul>
{/template}

{template Admin.Widget.UserInfo.AdminUserInfoBasic}
	{meta override=true}
	{link_to_login('Admin',['admin','index'],null,'dropdown')}
	<ul>
		{if OPTION('require-admin-cookie') == 'yes'}
			<li class="require-noadmin"><a href="javascript:void(0);">Downgrade...</a></li>
		{/if}
		<li>{link_to_login('Übersicht',['admin','index'])}</li>
		<li>{link_to_login('Suche',['admin','search','document'])}</li>

		{* this distinction normally is not necessary. I added this to be more failure tolerant *}
		{if GrinEnv.realm == 'grin'} 
			<li>{link_to_login('Neue Manuskripte',['admin','integrity','document_new'])}</li>
		{else}
			<li>{link_to_login('Neue Manuskripte',['admin','integrity','realm_document_new'])}</li>
		{/if}

		{*<li>{link_to_login('Druck'        ,['admin','integrity','document_wait_final_check'])}</li>
		<li>{link_to_login('Kategorie',['admin','categories'])}</li>*}

		<li>{link_to_login('Kunde anlegen',        ['admin','user'])}</li>

		{if login().admin_groups.realm}
			<li><hr/></li>
			<li>{link_to_login('Realm Files',['admin','realmfiles'])}</li>
			<li>{link_to_login('Verlagsimpressum',['admin','realm_imprints'])}</li>
			<li>{link_to_login('Genre',['admin','realm_genres'])}</li>
			<li>{link_to_login('CMS',['admin','cms'])}</li>
			<li>{link_to_login('Blog',['admin','blog'])}</li>
			<li>{link_to_login('Sidebar',['admin','sidebar'])}</li>
		{/if}
		<li><hr/></li>
		<li><a>{link_to_login('Reporting'           ,['admin','reporting'])}</a></li>
		<li><a>{link_to_login('Nutzerverwaltung',['admin','search','user'])}</a></li>
	</ul>
{/template}
