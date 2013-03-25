{namespace Page.User}

{template .Heading}
	{meta override=true}
	{call Widget.BreadCrumbs.Main}
{/template}

{template .Main}
	{meta override=true}
	<section class="cbox page-user-top">
		<h2>{NLS('Page::Text::Sidebar::AutorBox::Profile')}</h2>
		{call .Top.Main}
	</section>
	<hr>
	{* <h2>{NLS('Page::Profile::AuthorDetails')}</h2> *}
	{* this should be solved in a cleaner way. see: #2020 *}
	{if hasObjectProperty(_,'profile.about')}
		{call .MiddleSection.Main}
	{else}
		<p class="no-public-profile">
			{NLS('Page::User::NoPublicProfile')}
		</p>
	{/if}
{/template}

{template .Top.Social}
	{meta override=true}
	{call Widget.ShareBox.Follow}
	{call Widget.ShareBox.BigThree}

	<div class="grineditor foldable-container folded-container follower-list-editor"
		 grin:foldable-id="follower-list-{_.GUID}"
		 grin:editor="Gtpl_Editor"
		 grin:related-guid="{_.GUID}"
		 grin:aspects="follower"
		 grin:template="Widget.ShareBox.FollowerList"
		 grin:template-namespace="Widget.ShareBox"
		 grin:redraw="no"
	>
	</div>
{/template}