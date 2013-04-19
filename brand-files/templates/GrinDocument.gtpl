{namespace Page.Document}


{template .Layout}
  {call Structure.Layout.RightSidebar}
{/template}


{template .Heading}
  {meta override=true}
  
{/template}


{template .Main}
  {meta override=true}
  {if _.non_academic}
    {Call Widget.BreadCrumbs.Main root=_.non_academic.realm_genre}
      {param link_last_item=true}
    {/Call}
  {elseif _.academic}
    {Call Widget.BreadCrumbs.Main root=_.academic.subject}
      {param link_last_item=true}
    {/Call}
  {/if}

  <div class="document-upload-banner">
    <p class="info">
      {NLS('Page::Banner::BecomeAnAuthor')}
    </p>
    {link_to(NLS('Page::Banner::BecomeAuthorNow'),OPTION('base-href-upload',{lang:GrinEnv.lang}), 'linkbutton poi', {'grin:poi': 'CLICK_UPLOADBANNER'})}
  </div>

 {call .TopSection.Main}
  {call .MiddleSection.Main}

  {call .BottomSection.Main}

  {if _.grin_paper.available == 'YES'}
    {Call Widget.Popup.Main}
      {param popup_id='document-preview-popup'}
      {param foldable_id='document-preview-popup'}
      {container POPUPCONTENT=.PreviewPopup.Main}
    {/Call}
  {/if}
{/template}

{template .TopSection.Social}
  {meta override=true}
{/template}

{template .Meta.Bottom}
  {meta override=true}
{/template}

{template .MiddleSection.Main}
  {meta override=true}

  <section class="page-document-middlesection page-document-overview cbox">
    {if login().is_admin}
      <nav class="special-tabs">
        {link_to_document('Settings', _._id, 'settings/basicdata')}
        {link_to_document('Admin', _._id, 'settings/admin')}
      </nav>
    {/if}

    {call .MiddleSection.Overview}
  </section>
{/template}

{template .MiddleSection.Overview}
  {meta override=true}
  <span class="highlights">{NLS('Page::Document::StandardShop::Content')}</span>
  {if _.text.render_mode == 'none'}
    {call .MiddleSection.Abstract}
  {else}
    {call .MiddleSection.Text}
  {/if}
{/template}


{template .BottomSection.Main}
  {meta override=true}
{/template}

{template .Sidebar}
  {meta override=true}  
  <div class="safe-payment">
    <p class="sp-highlight">
      {NLS('Page::Document::StandardShop::SafePayment')}
    </p>
    <p>
      {NLS('Page::Document::StandardShop::PaymentContent')}
      <ul>
        <li>{NLS('Page::Document::StandardShop::PayPal')}</li>
      </ul>
    </p>
  </div>
{/template}