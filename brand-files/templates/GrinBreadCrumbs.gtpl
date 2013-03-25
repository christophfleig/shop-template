{*
*
* Compatible with following roots:
* document (aspect: document_academic)
* subject (aspect: subject_parents)
* [search].query (relies on _.searchstring)
*
* PARAM: _p.link_last_item (default: false)
* 
*}

{template Widget.BreadCrumbs.Main}
	{meta override=true}
	<div class="breadcrumbs">
		{NLS('Page::Commons::YouAreHere')}:&#160;&#160;&#160;
		{if typeof(_) === 'string'}
			{link_to( NLS('Page::Commons::Homepage') , OPTION('base-href-main') )}&#160;&gt;&#160;{_}
		{elseif _._class == 'subject'}
			{link_to( NLS('Page::Commons::Homepage') , OPTION('base-href-main') )}&#160;&gt;&#160;
			{foreach subject in _.parents}
				{link_to(NLS(subject.catalog_name).replace(/.* - /,''),subject.grin_url)}&#160;&gt;&#160;
			{/foreach}
			{if _p.link_last_item}
				{link_to(NLS(_.catalog_name).replace(/.* - /,''), _.grin_url)}
			{else}
				{NLS(_.catalog_name).replace(/.* - /,'')}
			{/if}

		{elseif _._class == 'realm_genre'}
			{link_to( NLS('Page::Commons::Homepage') , OPTION('base-href-main') )}&#160;&gt;&#160;
			{if _p.link_last_item}
				{link_to(_.name, _.grin_url)}
			{else}
				{_.name}
			{/if}
		{elseif _._class == 'user'}
			{link_to( NLS('Page::Commons::Homepage') , OPTION('base-href-main') )}&#160;&gt;&#160;
			{link_to(NLS('Page::Menu::Authors'),OPTION('base-href-authors'))}
		{elseif _.value && _.value.searchstring}
			{link_to( NLS('Page::Commons::Homepage') , OPTION('base-href-main') )}&#160;&gt;&#160;
			{NLS('Page::Search::ResultsFor')}&#160;&#187;&#160;<b>{_.value.searchstring}</b>&#160;&#171;
		{else}
			{NLS('Page::Commons::Homepage')}
		{/if}
	</div>
{/template}
