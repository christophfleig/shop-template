{namespace Page.Catalog}

{template .Heading}
	{call Widget.BreadCrumbs.Main}
{/template}

{template .Main}
	<ul class="cbox page-catalog-main">
		{if _.children}
			{call .Sub_Subjects}
		{/if}

		{if _.genres}
			{call .Realm_Genres}
		{/if}
	</ul>
{/template}

{template .Realm_Genres}
	{foreach realm_genre in _.genres.sort(keyComparator('url_path'))}
		<li class="realm_genre catalog-item">
			<h3 class="title">
				{link_to(realm_genre.name,realm_genre.grin_url)}
			</h3>
			<p class="no-of-documents">
				{realm_genre.count_documents}&#160;{NLS('Page::Commons::e-books_lc')}
			</p>
		</li>
	{/foreach}
{/template}

{template .Sub_Subjects}
	{foreach subject in _.children.sort(keyComparator('catalog_sortstring'))}
		{if subject.count_documents > 0}
			<li class="subject catalog-item">
				<h3 class="title">
					{link_to_subject(subject)}
				</h3>
				<p class="no-of-documents">
					{subject.count_documents}&#160;{NLS('Page::Commons::e-books_lc')}
				</p>
			</li>
		{/if}
	{/foreach}
{/template}