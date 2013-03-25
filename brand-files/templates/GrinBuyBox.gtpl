{template Widget.Buybox.MainOLD}
    {meta override=true}
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

        <div class="columns no-padding-vertical with-small-rounded-corners" tyle="padding-top: 10px; border: 1px solid #d0d0d0; width: {if _p.ispngpreview == 'true'}96%{else}91%{/if}; ">
            {*<div class="with-small-rounded-corners" style="padding-top: 10px; border: 1px solid #d0d0d0; width: {if _p.ispngpreview == 'true'}96%{else}91%{/if}; ">*}
                {param first_product=true}
                {if _.products.ebook}
                    {Call Frameset.Buybox.BuyboxProductOLD root=_.products.ebook}
                        {param product='ebook'}
                    {/Call}
                    {param first_product=false}
                {/if}
                {if _.products.printing_version}
                    {Call Frameset.Buybox.BuyboxProductOLD root=_.products.printing_version}
                        {param product='printing_version'}
                    {/Call}
                    {param first_product=false}
                {/if}
                {* PRICING TEST: FILTER BOOKS WHICH ARE MORE EXPENSIVE THAN EBOOKS *}
                {if _.products.book && (getObjectProperty(_,'products.ebook.value') || 0) < _.products.book.value}
                    {Call Frameset.Buybox.BuyboxProductOLD root=_.products.book}
                        {param product='book'}
                    {/Call}
                    {param first_product=false}
                {/if}
                {if _.products.print_author}
                    {Call Frameset.Buybox.BuyboxProductOLD root=_.products.print_author}
                        {param product='print_author'}
                    {/Call}
                    {param first_product=false}
                {/if}
                {if keys(_.products).length == 0}
                    {NLS('Page::Document::AvailableSoon')}
                {/if}
            {*</div>*}
        </div>    
        <br class="clear-all"/>
        {if keys(_.products).length}
            <div class="align-right {if _p.ispngpreview != 'true'}p10px-right{/if}" {if _p.location == 'bottom' && _p.ispngpreview != 'true'}style="padding-right: 30px;"{/if}>
                <button type="submit" class="medium icon shopping-cart bg-action">
                    <span style="font-size:14px;">{NLS('Page::Commons::AddToCart')}</span>
                </button>
            </div>
        {/if}
    </form>    
{/template}

{template Frameset.Buybox.BuyboxProductOLD}
    {meta override=true}
    {if !_p.first_product} {*is needed*}
        <hr class="m10px-top " style="margin-bottom: 10px;"/>
    {/if}
    <div class="input-area" style="">
        <label style="font-weight: normal; cursor: pointer; ">
            <input type="radio" name="product" value="{_p.product}" {if _p.first_product}checked="checked"{/if} />
            {if _p.product == 'ebook'}
                {NLS('Page::Commons::EbookPDF')} {NLS('Page::Commons::ForOnly')} <b style="font-size: 14px;">{_.formatted}</b><br/><span class="color-gray" style="margin-left: 16px; display: block;">{NLS('Page::Commons::DownloadImmediately')}</span>
            {elseif _p.product == 'book'}
                {NLS('Page::Commons::Book')} {NLS('Page::Commons::ForOnly')} <b style="font-size: 14px;">{_.formatted}</b><br/><span class="color-gray" style="margin-left: 16px;  display: block;">{NLS('Page::Commons::FreeShipping2')}</span>
            {elseif _p.product == 'print_author'}
                {NLS('Page::Commons::YourBook')} {NLS('Page::Commons::ForOnly')} <b style="font-size: 14px;">{_.formatted}</b><br/><span class="color-gray" style="margin-left: 16px;  display: block;">{NLS('Page::Commons::FreeShipping2')}</span>
            {elseif _p.product == 'printing_version'}
                {NLS('Page::Commons::PrintVersion')} {NLS('Page::Commons::ForOnly')} <b style="font-size: 14px;">{_.formatted}</b><br/><span class="color-gray" style="margin-left: 16px; display: block;">{NLS('Page::Commons::DownloadImmediately')}</span>
            {/if}
        </label>
    </div>
{/template}
