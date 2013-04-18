{namespace Page.Document}

{template .Heading}
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

  {if GrinEnv.test_group == 'A'}
    {call .TopSection.Main}
  {/if}
{/template}

<!--{template .Sidebar}
  {if GrinEnv.test_group == 'B'}
    {call .TestGroupB.SidebarAuthorBox}
  {/if}

  {call Structure.Defaults.Sidebar}
{/template}-->

{template .TestGroupB.SidebarAuthorBox}
  <section class="authorbox cbox">
    <div class="sidebar-heading">
      {NLS('Page::Commons::Author')}
    </div>

    {if _ctx.maindata.authors.length}
      {param author=_ctx.maindata.authors[0]}
      {param user=_p.author.user || {}}
      <div class="picturebox">
        {picture(_p.user, 'related', true, null, false, true)}
      </div>
      <div class="meta">
        <div class="heading1">
          {link_to_object(_p.author, 'author')}
        </div>

        <dl class="metalist">
          {if _p.user.count_public_documents > 0}
            <dt class="no_of_texts">{NLS('Page::Tabs::Texts')}</dt>
            <dd class="no_of_texts">{_p.user.count_public_documents}</dd>
          {/if}
          {if _p.user.country_id}
            <dt class="country">{NLS('Page::Commons::Country')}</dt>
            <dd class="country">{link_to_country(_p.user.country_id, null, {'rel':'nofollow'})}</dd>
          {/if}

          {if _p.user.created > 0}
            <dt class="member_since">{NLS('Page::Commons::GRINMemberSince')}</dt>
            <dd class="member_since">{format_date(_p.user.created)}</dd>
          {/if}
        </dl>
      </div>
    {else}
      <div class="picturebox">
        {picture(null,'related')}
      </div>
      <div class="meta">
        <div class="heading1">
          {NLS('Page::Commons::Author::Anonymous')}
        </div>
      </div>
    {/if}
  </section>
{/template}

{template .Main}
  {meta override=true}

  {if GrinEnv.test_group == 'B'}
    {call .TopSection.MainB}
  {/if}

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

{template .TopSection.MainB}
  <section class="page-document-top cbox">
    <section class="picturebox">
      {call .TopSection.Picturebox}
    </section>
    <section class="meta">
      {call .TopSection.Meta.Main}
      {call Widget.Buybox.Main root=_}
      {call .Meta.Bottom}
    </section>
  </section>    
{/template}



{template .TopSection.Social}
  {meta override=true}
  {call Widget.ShareBox.Main}
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

{template .TestGroupB.SocialBox}
  <section class="social">
    {call Widget.ShareBox.Main}
  </section>
{/template}

{template .MiddleSection.Overview}
  {meta override=true}
  {call .MiddleSection.Banner}

  {if GrinEnv.test_group == 'B'}
    {call .TestGroupB.SocialBox}
  {/if}
  {if _.text.render_mode == 'none'}
    {call .MiddleSection.Abstract}
  {else}
    {call .MiddleSection.Text}
  {/if}

  {if _.academic}
    <h2 class="heading1">{NLS('Page::Commons::Details')}</h2>
    {call .MiddleSection.Meta.Academic}
    {call .MiddleSection.CitesAndUrls}
  {elseif _.non_academic}
    {call .MiddleSection.Meta.NonAcademic}
  {/if}
  {call .MiddleSection.RelatedObjByPurchase}
  {call .MiddleSection.BottomComments}
{/template}


{template .MiddleSection.Meta.Academic}
  {meta override=true}
  <section class="meta">
    <dl>
      {if _.title}
        <dt class="docTitle">{NLS('Page::Commons::Title')}</dt>
        <dd class="docTitle">{_.title}</dd>
      {/if}
      {if _.subtitle}
        <dt class="docSubtitle">{NLS('Page::Commons::SubTitle')}</dt>
        <dd class="docSubtitle">{_.subtitle}</dd>
      {/if}
      {if _.academic.course}
        <dt class="event">{NLS('Page::Commons::Event')}</dt>
        <dd class="event">{_.academic.course}</dd>
      {/if}

      {if _.authors.length}
        <dt class="authors">{if _.authors.length == 1}{NLS('Page::Commons::Author')}{else}{NLS('Page::Commons::Authors')}{/if}</dt>
        <dd class="authors">{call Widget.AuthorList.Main root=_.authors}</dd>
      {/if}

      {if _.academic.year_of_text}
        <dt class="year">{NLS('Page::Commons::Year')}</dt>
        <dd class="year">{_.academic.year_of_text}</dd>
      {/if}

      {if _.ebook.page_count}
        <dt class="page_count">{NLS('Page::Commons::PagesNumber')}</dt>
        <dd class="page_count">{_.ebook.page_count}</dd>
      {/if}

      <dt class="archive_no">{NLS('Page::Commons::ArchiveNumber')}</dt>
      <dd class="archive_no">V{_._id}</dd>

      {if has_isbn(_,'ebook')}
        <dt class="isbn_ebook">{NLS('Page::Commons::ISBN')} ({NLS('Page::Commons::EBook')})</dt>
        <dd class="isbn_ebook">{get_isbn(_,'ebook')}</dd>
      {/if}

      {if get_isbn(_,'book')}
        <dt class="isbn_book">{NLS('Page::Commons::ISBN')} ({NLS('Page::Commons::Book')})</dt>
        <dd class="isbn_book">{get_isbn(_,'book')}</dd>
      {/if}

      {if _.identifiers.doi}
        <dt class="doi">{NLS('Page::Commons::DOI')}</dt>
        <dd class="doi">{_.identifiers.doi}</dd>
      {/if}

      {if _.ebook.file_size}
        <dt class="file_size">{NLS('Page::Commons::Size')}</dt>
        <dd class="file_size">{Math.floor(_.ebook.file_size / 1024)} KB</dd>
      {/if}

      <dt class="language">{NLS('Page::Commons::Language')}</dt>
      <dd class="language">{ENLS('languages',_.language_id)}</dd>

      {if _.groups && _.groups.length}
        <dt class="groups">{NLS('Page::Group::Groups')}</dt>
        <dd class="groups">
          {foreach group in _.groups}
          {link_to(group.name,group.grin_url)}
          {if !group$last},&#160;{/if}
          {/foreach}
        </dd>
      {/if}

      {if _.collections && _.collections.length}
        <dt class="collections">{NLS('Page::Group::Series::tab')}</dt>
        <dd class="collections">
          {foreach collection in _.collections}
            {link_to(collection.title, OPTION('base-href-group', {ID: collection.reference_id, PATH: ''}))}
            {if !collection$last},&#160;{/if}
          {/foreach}
        </dd>
      {/if}
      {if _.notes.notes}
        <dt class="notes">{NLS('Page::Commons::Notes')}</dt>
        <dd class="notes">{_.notes.notes}</dd>
      {/if}


      {if _.search_tags && _.search_tags.length}
        <dt class="tags">{NLS('Page::Commons::Tags')}</dt>
        <dd class="tags">
          {foreach tag in _.search_tags}
            {link_to_document_tag(tag)}
          {/foreach}
        </dd>
      {/if}
    </dl>
  </section>
{/template}

{template .MiddleSection.CitesAndUrls}
  {meta override=true}
  {* Quotation *} 
  <section class="page-document-quotepaper fullWidthDl">
    <dl>
      <dt>{NLS('Page::Text::QuoteText')}</dt>
      <dd>
        {call Widget.AuthorList.Main root=_.authors},&#32;
        {_.academic.year_of_text},&#32;{_.title},&#32;{NLS('Page::Commons::Munich')},&#32;{NLS('Page::Imprint::GRINVerlagOHG')}, {_.grin_url}
      </dd>
    </dl>
  </section>

  {* Embed code *}
  <section class="page-document-embed fullWidthDl">
    <dl>
      <dt>{NLS('Page::Commons::Embed')}</dt>
      <dd>
        <textarea class="trackback-target" onClick="this.select();">{_.grin_paper.embed}</textarea>
      </dd>
    </dl>
  </section>

  {* DOI Url *} 
  {if _.identifiers && _.identifiers.doi}
    <section class="page-document-doi-url">
      <dl>
        <dt>{NLS('Page::Commons::DOI')}</dt>
        <dd>
          <div class="hint">
            <textarea class="hint-target" onClick="this.select();">{OPTION('extern-href-doi-link', {doi: _.identifiers.doi})}</textarea>
            <div class="hint-text">{NLS('Page::Commons::DOI::Explanation')}</div>
          </div>
        </dd>
      </dl>
    </section>
  {/if}

{/template}

{template .MiddleSection.BottomComments}
{meta override=true}
<section class="page-document-comment"</section>
  <h2 class="heading2">{NLS('Page::Commons::Comments')}</h2>
    {call .MiddleSection.Comments}
</section>
{/template}

{template .MiddleSection.RelatedObjByPurchase}
  <section class="sidebar-related_objects_by_purchase">
    <h4 class="heading2">{NLS('Page::Text::Commons::Similar')}</h4>
    {Call Widget.GridCarousel.Main root=_ctx.related_objects_by_purchase}
      {param rows=1}
      {param cols=2}
    {/Call}
  </section>
{/template}


{template .Meta.Bottom}
  {meta override=true}
{/template}

{template .BottomSection.Main}
  {meta override=true}
{/template}