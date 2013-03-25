{namespace Sidebar}

{template .Block.FacebookLikebox}
	{if GrinEnv.lang == 'de' && OPTION('href-extern-facebook-likebox')}
		<section class="sidebar-facebook cbox">
			<iframe src="{OPTION('href-extern-facebook-likebox')}" scrolling="no" frameborder="0" 
			style="background: white; border:none; overflow:hidden; width: 295px; height:330px; padding: 0px; position: relative; left: -13px; top: -8px;" 
			allowTransparency="true">
			</iframe>
		</section>
	{/if}
{/template}

{template .Block.NextSteps}
	{if _ctx.next_steps}
		<section class="sidebar-next-steps cbox foldable">
			<div class="sidebar-heading">{NLS('Page::Commons::NextSteps')}</div>
			{* User Next Steps *}
			{if _ctx.next_steps.user_next_steps}
				<div class="user-actions">
					{if _ctx.next_steps.user_next_steps.bank_details}
						<p class="user-actions-info">
							{NLS('Page::Sidebar::UserAccount::Info')}:
							<br/>
							{link_to_account(NLS('Page::Account::ContactDetails'),login().effective_user_id,'masterdata')}
						</p>
					{/if}
				</div>
			{/if}

			{* Document Next Steps *}
			{if _ctx.next_steps.document_next_steps}
				<div class="document-actions">
					<p class="document-actions-info">{NLS('Page::Sidebar::DocumentActions::Info')}</p>
					{foreach item in _ctx.next_steps.document_next_steps}
						{if item$index == 3}
							<a class="cursor-pointer foldable-trigger">{NLS('Page::Commons::ShowAll')}</a>
						{/if}

						<div class="document-action-list {if item$index >= 3}foldable-container{/if}">
							<p>
								<b>{truncate_string(item.object.title,20)}</b> (V{item.object._id}):
								<br/>
								{if item.next_steps.ebooklicense}
									&#187;&#160;{link_to_document(NLS('Page::Sidebar::DocumentActions::EBookLicenseMissing'),item.object._id, 'settings/licenses', 'scroll-top')}
									<br/>
								{/if}
								{if item.next_steps.booklicense}
									&#187;&#160;{link_to_document(NLS('Page::Sidebar::DocumentActions::BookLicensePossible'),item.object._id, 'settings/licenses', 'scroll-top')}
									<br/>
								{/if}
								{if item.next_steps.masterdata}
									&#187;&#160;{link_to_document(NLS('Page::Sidebar::DocumentActions::MasterDataMissing'),item.object._id, 'settings_basicdata', 'scroll-top')}
									<br/>
								{/if}
								{if item.next_steps.abstract}
									&#187;&#160;{link_to_document(NLS('Page::Sidebar::DocumentActions::AbstractMissing'),item.object._id, 'settings/abstract', 'scroll-top')}
									<br/>
								{/if}
							</p>
						</div>
					{/foreach}
				</div>
			{/if}
		</section>
	{/if}
{/template}

{template .Block.DocumentPrintAuthor}
	{if _ctx.printauthors}
		<div class="section with-boxes">
			<div class="sidebar-heading">{NLS('Page::Sidebar::DocumentPrintAuthor::Title')}</div>
			<div class="box rounded-corners with-shadows">
				<div class="top-box"></div>
				<div class="middle-box">
					<div class="sub-section bottom-line no-padding-top">
						<p>{NLS('Page::Sidebar::DocumentPrintAuthor::Info')}</p>
					</div>
					{foreach printauthor in _ctx.printauthors}
						<div class="sub-section {cycle['bg-white','bg-gray']} {if printauthor$last}no-padding-bottom{else}bottom-line{/if}">
							{link_to_login(printauthor.title + 'V' +printauthor.id, ['user',login().effective_user_id,'print_author'])}
						</div>
					{/foreach}
				</div>
				<div class="bottom-box {if _ctx.printauthors.length % 2 == 0}bg-white{else}bg-gray{/if}"></div>
			</div>
		</div>
	{/if}
{/template}

{template .Block.GrinVideoHowItWorks}
	<section class="sidebar-video cbox">
		<div class="sidebar-heading">{NLS('Page::Commons::GrinVideoHowItWorks')}</div>
		{Call Widget.Popup.Main}
		{Container POPUPTRIGGER}
		<span class="poi" grin:poi="CLICK_YOUTUBE_VIDEO_SIDEBAR_{GrinEnv.handler || ''}">
			{brand_img('grin_yt_video.png',null,'youtube-sidebar')}
		</span>
		{/Container}
		{Container POPUPCONTENT}
			<div class="video cbox">
				<h3>{NLS('Page::Commons::GrinVideoHowItWorks')}</h3>
				{NLS('Page::Commons::VideoEmbed')}
			</div>
		{/Container}
		{/Call}
		{*NLS('Page::Commons::SidebarGrinHowToVideo')*}
	</section>
{/template}


{template .Block.RelatedObjectsByPurchase}
	{meta override=true}
	{if _ctx.related_objects_by_purchase}
		<section class="sidebar-related_objects_by_purchase cbox">
			<div class="sidebar-heading">{NLS('Page::Text::Commons::Similar')}</div>
			{Call Widget.GridCarousel.Main root=_ctx.related_objects_by_purchase}
				{param rows=3}
				{param cols=1}
			{/Call}
		</section>
	{/if}
{/template}

{template .Block.AdminDocumentNeighbors}
	{if _ctx.admin_neighbor_ids}
		<section class="sidebar-admin-document-neighbors cbox">
			<div class="sidebar-heading">Admin</div>
			{if _ctx.admin_neighbor_ids.document_id_before}
				<p>
					{link_to_document('v' + _ctx.admin_neighbor_ids.document_id_before, _ctx.admin_neighbor_ids.document_id_before, 'settings/basicdata')}
				</p>
			{/if}
			{if _ctx.admin_neighbor_ids.document_id_after}
				<p>
					{link_to_document('v' + _ctx.admin_neighbor_ids.document_id_after, _ctx.admin_neighbor_ids.document_id_after, 'settings/basicdata')}
				</p>
			{/if}
		</section>
	{/if}
{/template}

{template .Block.Feed}
	{meta override=true}
	<section class="sidebar-feed cbox">
		{if login().effective_user_id}
			<div class="sidebar-heading">{NLS('Page::Commons::YourNews')}</div>
			<div class="grineditor"
				grin:editor="Gtpl_Editor"
				grin:template="Widget.Wall.Main"
				grin:template-namespaces="Widget.Wall,Widget.Comments"
				grin:redraw="no"
				grin:related-guid="feed.{login().effective_user_id}"
				grin:gtpl-params='{ldelim}"show_comments":false,"show_new_story_form":false,"max_stories":3{rdelim}'
				grin:aspects="stories_1_3">
				<div class="loading sub-section" style="min-height: 185px;">{NLS('Page::Commons::Loading')}</div>
			</div>
			<p class="m10px-top">
				{link_to_profile(NLS('Page::Commons::ShowAll'), login().effective_user, 'feed')}
			</p>
		{else}
			<div class="sidebar-heading">{NLS('Page::Commons::GRINNews')}</div>
			<div class="grineditor"
				grin:editor="Gtpl_Editor"
				grin:template="Widget.Wall.Main" 
				grin:template-namespaces="Widget.Wall"
				grin:redraw="no"
				grin:related-guid="world_feed.0"
				grin:gtpl-params='{ldelim}"show_comments":false,"show_new_story_form":false,"max_stories":3{rdelim}'
				grin:aspects="stories_1_3">
				<div class="loading sub-section"  style="min-height: 185px;">{NLS('Page::Commons::Loading')}</div>
			</div>
			<p class="m10px-top">
				{link_to(NLS('Page::Commons::ShowAll'), OPTION('base-href-network'))}
			</p>
		{/if}
	</section>
{/template}

{template .Block.AdminClipboard}
	{meta override=true}
	{if login().is_admin}
		<section class="sidebar-adminclipboard cbox">
			<div class="sidebar-heading">Object Clipboard</div>
			<div id="adminclipboard"
				class="grineditor"
				grin:editor="Gtpl_Editor"
				grin:template="Admin.Sidebar.Block.AdminClipboardContent" 
				grin:template-namespaces="Widget.MiniList,Admin.Widget.MiniList,Admin.Sidebar"
				grin:redraw="no">
			</div>
		</section>
	{/if}
{/template}

{template .Block.LastPurchase}
	{meta override=true}
	{if _ctx.last_purchases}
		<section class="sidebar-last-purchase cbox">
			<div class="sidebar-heading">{NLS('Page::LastPurchase')}</div>
			<p class="sidebar-last-purchase-info">{NLS('Page::LastPurchase::Info')}</p>
			{foreach account in _ctx.last_purchases}
				<div class="sidebar-last-purchase-entry">
					<a href="{account.grin_url}">
						<p class="meta">
							{NLS('Page::LastPurchase::PurchaseOn')}&#160;<b>{format_date(account.date)}</b>:
						</p>
						{foreach item in account.action.order_items}
							<p>
								&#187;&#160;{truncate_string(item.object.title,32)}
							</p>
						{/foreach}
					</a>
				</div>
			{/foreach}
		</section>
	{/if}
{/template}
