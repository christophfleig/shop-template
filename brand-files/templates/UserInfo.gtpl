{namespace Widget.UserInfo}

{template .Container}
	{meta override=true}
	<div id="userinfo" class="grineditor" grin:editor="Gtpl_Editor" grin:template="Widget.UserInfo.Main" grin:template-namespaces="Widget.UserInfo" grin:redraw="no" grin:nofx="yes" grin:skip_first_draw="yes">
		{call .Main}
	</div>
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
				{login().shoppingcart_account.document_transactions.length} {if login().shoppingcart_account.document_transactions.length == 1}{NLS('web::www.grin.com::Page::Sidebar::ShoppingCart::Item')}{else}{NLS('web::www.grin.com::Page::Sidebar::ShoppingCart::Items')}{/if}&#160;|&#160;<b>{login().shoppingcart_account.sums.sum_gross[0].formatted}</b>
			{else}
				0 {NLS('web::www.grin.com::Page::Sidebar::ShoppingCart::Items')}&#160;|&#160;{zero_amount()}
			{/if}
		</span> 
	</span> 
	{if login().shoppingcart_account}
		</a>
	{else}
		</div>
	{/if}
{/template}

{template .Main}
	{meta allow_override=true}
	<div class="top-info">
		{call .ShoppingCart}
	</div>
{/template}