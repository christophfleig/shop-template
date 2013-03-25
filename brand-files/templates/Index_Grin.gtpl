{namespace Page.Index}

{template .Heading}
	{* Breadcrumb *}
	{Call Widget.BreadCrumbs.Main}
		{param link_last_item=true}
	{/Call}
	<div class="visual home tabbar">
	<section class="active slide1" data-grin-tabnav-target="slide1">
		<div class="home-slider-text">
			<div class="home-slider-headline">{NLS('Page::Home::Slider::Section1Headline')}</div>
			<div class="home-slider-subheadline">{NLS('Page::Home::Slider::Section1SubHead')}</div>
		</div>
		<div class="upload-buttons">
				{link_to(NLS('Page::Commons::UploadNow'),OPTION('base-href-upload',{lang:GrinEnv.lang}), 'upload-button upload-dummybutton')}
		</div>
		{*call Widget.Upload.btnOnlyAsyncUploader*}
	</section>
	<section class="slide2" data-grin-tabnav-target="slide2">
		<div class="home-slider-text">
			<div class="home-slider-headline">{NLS('Page::Home::Slider::Section2Headline')}</div>
			<div class="home-slider-subheadline">{NLS('Page::Home::Slider::Section2SubHead')}</div>
		</div>
		<div class="upload-buttons">
				{link_to(NLS('Page::Commons::UploadNow'),OPTION('base-href-upload',{lang:GrinEnv.lang}), 'upload-button upload-dummybutton')}
		</div>
		{*call Widget.Upload.btnOnlyAsyncUploader*}
	</section>
	<section class="slide3" data-grin-tabnav-target="slide3">
		<div class="home-slider-text">
			<div class="home-slider-headline">{NLS('Page::Home::Slider::Section3Headline')}</div>
			<div class="home-slider-subheadline">{NLS('Page::Home::Slider::Section3SubHead')}</div>
		</div>
		<div class="upload-buttons">
				{link_to(NLS('Page::Commons::UploadNow'),OPTION('base-href-upload',{lang:GrinEnv.lang}), 'upload-button upload-dummybutton')}
		</div>
		{*call Widget.Upload.btnOnlyAsyncUploader*}
	</section>
	<section class="slide4" data-grin-tabnav-target="slide4">
		<div class="home-slider-text small">
			<div class="home-slider-headline">{NLS('Page::Home::Slider::Section4Headline')}</div>
			<div class="home-slider-subheadline">{NLS('Page::Home::Slider::Section4SubHead')}</div>
			{*call Widget.Upload.btnOnlyAsyncUploader*}
		</div>
		<div class="upload-buttons">
				{link_to(NLS('Page::Commons::UploadNow'),OPTION('base-href-upload',{lang:GrinEnv.lang}), 'upload-button upload-dummybutton')}
		</div>
		<div class="home-slider-box">
			{NLS('Page::Home::Slider::Box1')}
		</div>
		<div class="home-slider-box">
			{NLS('Page::Home::Slider::Box2')}
		</div>
		<div class="home-slider-box">
			{NLS('Page::Home::Slider::Box3')}
		</div>
		<div class="videoPopup">
			{Call Widget.Popup.Main}
			{Container POPUPTRIGGER}
			<div class="home-slider-box3 pointer">
				{NLS('Page::Home::Slider::Box4')}
			</div>
			{/Container}
			{Container POPUPCONTENT}
				<div class="video cbox">
					<h3>{NLS('Page::Commons::GrinVideoHowItWorks')}</h3>
					{NLS('Page::Commons::VideoEmbed')}
				</div>
			{/Container}
			{/Call}
		</div>
	</section>
	<section class="slide5" data-grin-tabnav-target="slide5">
		<div class="home-slider-text">
			<div class="home-slider-headline">{_ctx.brand_statistics.author_count}&#160;{NLS('Page::Home::Slider::Section5Headline')}</div>
			<div class="home-slider-subheadline">{NLS('Page::Home::Slider::Section5SubHead')}</div>
		</div>
		<div class="aboutgrin-1">
				{NLS('Page::Home::Slider::AboutGrin1')}
		</div>
		<div class="aboutgrin-2">
				{NLS('Page::Home::Slider::AboutGrin2')}
		</div>
		<div class="aboutgrin-3">
				{NLS('Page::Home::Slider::AboutGrin3')}
		</div>
		<div class="upload-buttons">
				{link_to(NLS('Page::Commons::UploadNow'),OPTION('base-href-upload',{lang:GrinEnv.lang}), 'upload-button upload-dummybutton')}
		</div>
		{*call Widget.Upload.btnOnlyAsyncUploader*}
	</section>

	<nav class="tabbar">
		<ul>
			{*<li class="nav-button" data-grin-microlink-href="slide1">*}
			<li class="nav-button active" data-grin-tabnav-href="slide1">
				{NLS('Page::Home::Slider::Nav1')}
				<div class="arrow-top"></div>
			</li>	
			<li class="nav-button" data-grin-tabnav-href="slide2">
				{NLS('Page::Home::Slider::Nav2')}
				<div class="arrow-top"></div>
			</li>
			<li class="nav-button" data-grin-tabnav-href="slide3">
				{NLS('Page::Home::Slider::Nav3')}
				<div class="arrow-top"></div>
			</li>
			<li class="nav-button" data-grin-tabnav-href="slide4">
				{NLS('Page::Home::Slider::Nav4')}
				<div class="arrow-top"></div>
			</li>
			<li class="nav-button" data-grin-tabnav-href="slide5">
				{NLS('Page::Home::Slider::Nav5')}
				<div class="arrow-top"></div>
			</li>
		</ul>
		<div class="clear-all"></div>
	</nav>
    </div>
{/template}

{template .Main}
	{if GrinEnv.brand == 'grin'}
		{Call .Grin.Main}
			{param TextBestseller = _['bestseller-document'] || []}
			{param TextPopular = _['popular-document'] || []}
			{if _['newest-document']}
				{param TextNewest = filter(itemgetter('title'),_['newest-document']) || []}
			{else}
				{param TextNewest=[]}
			{/if}
			{param TopAuthors = _['top-authors'] || []}
			{param UserNewest = _['newest-user'] || []}
			{param UserMostdocument = _['mostdocuments-user'] || []}
			{param UserMostread = _['mostread-user'] || []}
		{/Call}
	{else}
		{Call .Hausarbeiten.Main} {*This includes unterweisungen and dipl24. Relevant lists names dont include specific filters (.premium, .instruction)*}
			{param TextBestseller = _['bestseller-document'] || []}
			{param TextPopular = _['popular-document'] || []}
			{if _['newest-document']}
				{param TextNewest = filter(itemgetter('title'),_['newest-document']) || []}
			{else}
				{param TextNewest=[]}
			{/if}
		{/Call}
	{/if}

	{call .ShowSubjects root=_.cloud}
	{if GrinEnv.i_am_grin && GrinEnv.lang == 'de'}
			
		{call .LatestTopics root=_.latest_topics}
	{/if}
{/template}

{template .Grin.Main}

		{call .DocumentCarousels}
		{call .UserCarousels}
{/template}

{template .Hausarbeiten.Main}
		{call .DocumentCarousels}
{/template}



{template .ShowSubjects}
	<div class="cbox topSubjects">
		<h2>{NLS('Page::Commons::TopSubjects')}</h2>
				{* maybe <div style="position: absolute; border-left: 1px solid #E5E5E5; top: -15px; left: 314px; width: 10px; height: 15px; display: block;"></div> *}
					{param tagCountMax=listMax(_.map(itemgetter('count_documents')))}
					{param tagCountMin=listMin(_.map(itemgetter('count_documents')))}

					{foreach subject in _.sort(reverseKeyComparator('count_documents')).slice(0,10)}
						<div class="page-subjects-item">
								<a href="{subject.grin_url}" title="{subject.count_documents}&#160;{NLS('Page::Commons::Texts')}"><h3>{truncate_string(subject.catalog_name,25)}</h3></a>
								{subject.count_documents}&#160;{NLS('Page::Commons::Texts')}
						</div>
					{/foreach}
					<div class="clear-all"></div>
				<div class="page-subjects-item-link">
					<a href="{OPTION('base-href-main')}{GrinEnv.lang}/catalog/">{NLS('Page::Commons::ShowAllSubjects')}</a>
				</div>
	</div>
{/template}

{template .DocumentCarousels}
	<div class="cbox tabbar first">
		<h2>{if GrinEnv.brand == 'grin'}{NLS('Page::Home::TextsonGRIN')}{else}{NLS('Page::Commons::EbooksAndBooks')}{/if}</h2>
			<nav class="tabs">
                    {if _p.TextBestseller}
                    	{tabnavlink_to(NLS('Page::Commons::Bestseller'),  'bestrating', 'active')}
                    {/if}
					{if _p.TextNewest}
						{tabnavlink_to(NLS('Page::Commons::Newest') , 'newest' )}
                    {/if}
                    {if _p.TextPopular}
                    	{tabnavlink_to(NLS('Page::Commons::MostRead'),	'mostread' )}
                    {/if}
			</nav>
            {if _p.TextNewest}
    			<section data-grin-tabnav-target="newest">
    					{call Widget.GridCarousel.Main root=_p.TextNewest}
    			</section>
    		{/if}
            {if _p.TextBestseller}
    			<section class="active" data-grin-tabnav-target="bestrating">
    					{call Widget.GridCarousel.Main root=_p.TextBestseller}
    			</section>
            {/if}
            {if _p.TextPopular}
    			<section data-grin-tabnav-target="mostread">
    					{call Widget.GridCarousel.Main root=_p.TextPopular}
    			</section>
            {/if}
	</div>
{/template}

{template .TopAuthorCarousel}
	<div class="cbox">
		<h2>{if GrinEnv.brand == 'grin'}{NLS('Page::Home::TopAuthorsAtGRIN')}{else}{NLS('Page::Home::TopAuthors')}{/if}</h2>
					{Call Widget.Carousel.Main root=_p.TopAuthors}
						{param type='related'}
						{param position='article'}
						{param show_page_indicator=true}
					{/Call}
	</div>
{/template}

{template .UserCarousels}
	{call .TopAuthorCarousel}
{/template}

{template .TabbedUserCarousels}
	<div class="cbox tabbar">
		<h2>{NLS('Page::Home::AuthorsAtGRIN')}</h2>
			<nav class="tabs">
					{tabnavlink_to(NLS('Page::Commons::Newest'),  'newest-user', 'active')}
					{tabnavlink_to(NLS('Page::Commons::MostRead'),  'mostread-user' )}
					{tabnavlink_to(NLS('Page::Commons::MostTexts'),  'mostdocuments-user' )}
			</nav>
			<section class="active" data-grin-tabnav-target="newest-user">
					{Call Widget.Carousel.Main root=_p.UserNewest}
						{param type='related'}
						{param position='article'}
						{param show_page_indicator=true}
					{/Call}
			</section>
			<section data-grin-tabnav-target="mostread-user">
					{Call Widget.Carousel.Main root=_p.UserMostread}
						{param type='related'}
						{param position='article'}
						{param show_page_indicator=true}
					{/Call}
			</section>
			<section data-grin-tabnav-target="mostdocuments-user">
					{Call Widget.Carousel.Main root=_p.UserMostdocument}
						{param type='related'}
						{param position='article'}
						{param show_page_indicator=true}
					{/Call}
			</section>
	</div>
{/template}

{template .LatestTopics}
	<div class="cbox">
		<h2>{NLS('Page::Commons::CurrentTopics')}</h2>
					{foreach topic in _}
						<div class="page-topics-item">
							<h3>
								{link_to_topic(topic)}
							</h3>
							{topic.document_count}&#160;{NLS('Page::Commons::Texts')}
						</div>
					{/foreach}
					<div class="clear-all"></div>
		
		<div class="page-topics-item-link">
			{link_to(NLS('Page::Commons::ShowAll'),OPTION('base-href-topics'))}
		</div>
	</div>
{/template}
