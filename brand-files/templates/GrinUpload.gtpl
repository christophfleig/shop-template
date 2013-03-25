{namespace Page.Upload}


{template .Title}
	<title>{OPTION('pagetitle-brandname')} | {NLS('Page::Commons::Upload')} | {NLS('Page::Title::UploadInfo')}</title>
{/template}

{template .Layout}
	{call Structure.Layout.Fullwidth}
{/template}

{template .Heading}
	{Call Widget.BreadCrumbs.Main root=NLS('Page::Commons::BecomeAnAuthor')}
		{param link_last_item=true}
	{/Call}
	<div class="upload-header tabbar">
		<section class="active upload-banner" data-grin-microlink-target="upload-banner1" data-grin-microlink-fallback-target="">
			<div class="home-slider-text upload">
				<div class="home-slider-headline">{NLS('Page::Upload::Slider::Head')}</div>
				<div class="home-slider-subheadline">{NLS('Page::Upload::Slider::SubHead')}</div>
			</div>
			<section class="upload-banner-boxes">
				<div class="upload-banner-box" data-grin-microlink-href="upload-banner2">
							<h3 class="title">{NLS('Page::Upload::Slider::Section1::Headline')}</h3><a class="openBanner" href="javascript:void(0);">{NLS('web::www.grin.com::Page::Commons::More')}</a>
				</div>
				<div class="upload-banner-box" data-grin-microlink-href="upload-banner3">
							<h3 class="title">{NLS('Page::Upload::Slider::Section2::Headline')}</h3><a class="openBanner" href="javascript:void(0);">{NLS('web::www.grin.com::Page::Commons::More')}</a>
				</div>
				<div class="upload-banner-box" data-grin-microlink-href="upload-banner4">
							<h3 class="title">{NLS('Page::Upload::Slider::Section3::Headline')}</h3><a class="openBanner" href="javascript:void(0);">{NLS('web::www.grin.com::Page::Commons::More')}</a>
				</div>
				<div class="upload-banner-box" data-grin-microlink-href="upload-banner5">
							<h3 class="title">{NLS('Page::Upload::Slider::Section4::Headline')}</h3><a class="openBanner" href="javascript:void(0);">{NLS('web::www.grin.com::Page::Commons::More')}</a>
				</div>
				<iframe class="grin-video" width="500" height="270" src="{NLS('Page::Commons::VideoEmbedLink')}" frameborder="0" allowfullscreen>
            	</iframe>
			</section>
			{call .uploadBtnBlock}
		</section>
		<section class ="upload-banner2" data-grin-microlink-target="upload-banner2">
			<div class="home-slider-text upload">
				<div class="home-slider-headline">{NLS('Page::Upload::Slider::Head')}</div>
				<div class="home-slider-subheadline">{NLS('Page::Upload::Slider::SubHead')}</div>
			</div>
			<section class="upload-banner-boxes">
				<div class="upload-banner-box2" data-grin-microlink-href="upload-banner1" data-grin-microlink-fallback-href="">
							<div class=""><h3>{NLS('Page::Upload::Slider::Section1::Headline')}</h3></div>
							<div class="">
								{NLS('Page::Upload::Slider::Section1::Text')}
							</div>
							<a class="closeBanner" href="javascript:void(0);">{NLS('Page::Commons::Close')}</a>	
				</div>
				<iframe class="grin-video" width="500" height="270" src="{NLS('Page::Commons::VideoEmbedLink')}" frameborder="0" allowfullscreen>
            	</iframe>
			</section>
			{call .uploadBtnBlock}
		</section>
		<section class ="upload-banner2" data-grin-microlink-target="upload-banner3">
			<div class="home-slider-text upload">
				<div class="home-slider-headline">{NLS('Page::Upload::Slider::Head')}</div>
				<div class="home-slider-subheadline">{NLS('Page::Upload::Slider::SubHead')}</div>
			</div>
			<section class="upload-banner-boxes">
				<div class="upload-banner-box2" data-grin-microlink-href="upload-banner1" data-grin-microlink-fallback-href="">
							<div class=""><h3>{NLS('Page::Upload::Slider::Section2::Headline')}</h3></div>
							<div class="">
								{NLS('Page::Upload::Slider::Section2::Text')}
							</div>	
							<a class="closeBanner" href="javascript:void(0);">{NLS('Page::Commons::Close')}</a>	
				</div>
				<iframe class="grin-video" width="500" height="270" src="{NLS('Page::Commons::VideoEmbedLink')}" frameborder="0" allowfullscreen>
            	</iframe>
			</section>
			{call .uploadBtnBlock}
		</section>
		<section class ="upload-banner2" data-grin-microlink-target="upload-banner4">
			<div class="home-slider-text upload">
				<div class="home-slider-headline">{NLS('Page::Upload::Slider::Head')}</div>
				<div class="home-slider-subheadline">{NLS('Page::Upload::Slider::SubHead')}</div>
			</div>
			<section class="upload-banner-boxes">
				<div class="upload-banner-box2"  data-grin-microlink-href="upload-banner1" data-grin-microlink-fallback-href="">
							<div class=""><h3>{NLS('Page::Upload::Slider::Section3::Headline')}</h3></div>
							<div class="">
								{NLS('Page::Upload::Slider::Section3::Text')}
							</div>
							<a class="closeBanner" href="javascript:void(0);">{NLS('Page::Commons::Close')}</a>
				</div>
				<iframe class="grin-video" width="500" height="270" src="{NLS('Page::Commons::VideoEmbedLink')}" frameborder="0" allowfullscreen>
            	</iframe>
			</section>
			{call .uploadBtnBlock}
		</section>
		<section class ="upload-banner2" data-grin-microlink-target="upload-banner5">
			<div class="home-slider-text upload">
				<div class="home-slider-headline">{NLS('Page::Upload::Slider::Head')}</div>
				<div class="home-slider-subheadline">{NLS('Page::Upload::Slider::SubHead')}</div>
			</div>
			<section class="upload-banner-boxes">
				<div class="upload-banner-box2" data-grin-microlink-href="upload-banner1" data-grin-microlink-fallback-href="">
							<div class=""><h3>{NLS('Page::Upload::Slider::Section4::Headline')}</h3></div>
							<div class="">
								{NLS('Page::Upload::Slider::Section4::Text')}
							</div>	
							<a class="closeBanner" href="javascript:void(0);">{NLS('Page::Commons::Close')}</a>
				</div>
				<iframe class="grin-video" width="500" height="270" src="{NLS('Page::Commons::VideoEmbedLink')}" frameborder="0" allowfullscreen>
            	</iframe>
			</section>
			{call .uploadBtnBlock}
		</section>
	</div>
{/template}

{template .uploadBtnBlock}
	<div class="upload-upload-button">
		{call .btnOnlyAsyncUploader}
		<span class="upload-button-text">{_ctx.brand_statistics.author_count}&#160;{NLS('Page::Commons::authors_lc')} {NLS('Page::Upload::have_published')}!</span>
	</div>
{/template}

{template .btnOnlyAsyncUploader}
	{meta override=true}
	<div class="upload-document upload-async">
		<div class="upload_form_flash">
			<div class="upload-buttons">
				<a class="upload-button upload-dummybutton" href="javascript:void(0);">{NLS('Page::Upload::SelectFile')}</a>
				<span class="swf-placeholder"></span>
			</div>
			<div class="upload-info">
				<span class="upload-filename" ></span> (<span class="upload-filesize"></span> kB)&nbsp;&nbsp;
				<div class="upload-progressbar" > <div> </div> </div>
			</div>
		</div>
	</div>
{/template}

{template .Main}
	
	
{/template}
