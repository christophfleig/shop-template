{namespace Widget.Buybox}

{template .Main}
    {meta override=true}
    <div class="buybox-main">
		 


        {* EBOOKS *}
        {if _.products && _.products.ebook}
			{if _.products.ebook.promotion_free_download && _.products.ebook.promotion_free_download === 'YES'}
				{param first_product=true}
				{Call .FreeDownload}
					{param product='ebook'}
				{/Call}
			{else}
	            {Call .ShoppingCartButton}
	                {param product='ebook'}
	                {param dotbooks_name='eBook'}
	            {/Call}
	        {/if}
        {/if}
        
        {if _.products && _.products.epub}
			{if _.products.epub.promotion_free_download && _.products.epub.promotion_free_download === 'YES'}
				{param first_product=true}
				{Call .FreeDownload}
					{param product='epub'}
				{/Call}
			{else}
	            {Call .ShoppingCartButton}
	                {param product='epub'}
	                {param dotbooks_name='eBook'}
	            {/Call}
	        {/if}
        {/if}

        {* BOOK *}
        {if _.products && _.products.book}
            {Call .ShoppingCartButton}
                {param product='book'}
                {param dotbooks_name='printBook'}
            {/Call}
        {/if}

        {* PRINTED by AUTHOR *}
        {if _.products && _.products.print_author}
            {Call .ShoppingCartButton}
                {param product='print_author'}
            {/Call}
        {/if}

        {* PRINTING VERSION *}
        {if _.products && _.products.printing_version}
            {Call .ShoppingCartButton}
                {param product='printing_version'}
            {/Call}
        {/if}

        {* Affiliate *}
        {if _.products && _.products.ebook}
            {Call .AffiliateButton}
            {/Call}
        {/if}
        {*{if _.products && _.products.epub}
            {Call .AffiliateButton}
            {/Call}
        {/if}*}

        {* AVAILABLE SOON *}
        {if _.products && keys(_.products).length == 0}
            {NLS('Page::Document::AvailableSoon')}
        {/if}
    </div>
    <div class="clear-all"></div>
{/template}



{template .ShoppingCartButton}
    <form method="post" action="{OPTION('base-href-shoppingcart')}">
        <input type="hidden" name="method" value="add"/>
        <input type="hidden" name="source_type" value="document"/>
        <input type="hidden" name="reference_id" value="{_._id}"/>
        <input type="hidden" name="test_group" value="{GrinEnv.test_group}"/>
        <input type="hidden" name="test_gang" value="{GrinEnv.test_gang}"/>
        <input type="hidden" name="test_bunch" value="{GrinEnv.test_bunch}"/>
        <input type="hidden" name="test_brand" value="{GrinEnv.brand}{if GrinEnv.i_am_secure}-https{/if}"/>
        <input type="hidden" name="test_button_id" value="{_p.location || 'top'}"/> 
        <input type="hidden" name="partner_id" value="{GrinEnv.partner_id || 0}"/>
        <input type="hidden" name="product" value="{_p.product}"/>

        <button type="submit" class="shopping-cart-button">
{*          <span style="font-size:14px;">{NLS('Page::Commons::AddToCart')}</span>*}
{*          <span>{_p.dotbooks_name}<br/>€ {format_price(_.products[_p.product].value)}</span>  *}
            <span>{_p.dotbooks_name}<br/>{get_price_formatted(_,_p.product)}</span>  
        </button>

    </form>    
{/template}

{*{template .AffiliateButton}
	<div style="width: 100px; margin-left: 5px; float: left; margin-top: 8px;">
    <div class="amazon-button" style="margin-left: 10px;"><a href="http://www.amazon.de/s/ref=nb_sb_noss?ie=UTF-8&url=search-alias%3daps&tag=httpwwwdotboo-21&field-keywords={_.title}+dotbooks" target="_blank" title="{_.title} im Amazon Kindle Shop kaufen. Verfügbar für die Amazon Kindle Plattformen: Kindle Reader, Kindle for PC, Kindle for iPad/iPhone/iPod, Kindle for Android, Kindle for Windows Phone.">{brand_img('amazon_badge.png',null,null)}</a></div>
    <div class="amazon-button"><a href="http://clkuk.tradedoubler.com/click?p=23761&a=2136745&url=http://itunes.apple.com/de/book/isbn{_.identifiers.isbns.ebook.ean}&partnerId=2003" target="_blank" title="{_.title} im iBooks Store kaufen. Verfügbar für die Apple iOS Geräte iPhone, iPad und iPod touch. Voraussetzung ist die Installation der kostenlosen iBooks App.">{brand_img('ibookstore_badge.png',null,null)}</a></div>
	</div>
{/template}*}
