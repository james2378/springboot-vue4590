import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue';
import login from '../views/login.vue';
import forgot from '../views/forgot.vue';
Vue.use(VueRouter)

const routes = [
	// 主页
	{
		path: '/',
		name: 'index',
		component: index,
		meta: {
			index: 0,
			title: '首页'
		}
	},

	// 登录
	{
		path: '/login',
		name: 'login',
		component: login,
		meta: {
			index: 0,
			title: '登录'
		}
	},


	// 忘记密码
	{
		path: '/forgot',
		name: "forgot",
		component: forgot,
		meta: {
			index: 0,
			title: '忘记密码'
		}
	},

	// 修改密码
	{
		path: '/user/password',
		name: "password",
		component: () => import("../views/user/password.vue"),
		meta: {
			index: 0,
			title: '修改密码'
		}
	},

	// 视频播放页
	{
		path: "/media/video",
		name: "video",
		component: () => import('../views/media/video.vue'),
		meta: {
			index: 0,
			title: "视频"
		}
	},

	// 音频播放页
	{
		path: "/media/audio",
		name: "audio",
		component: () => import('../views/media/audio.vue'),
		meta: {
			index: 0,
			title: "音频"
		}
	},



	// 友情链接路由
	// {
	// 	path: '/link/table',
	// 	name: 'link_table',
	// 	component: () => import('../views/link/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接列表'
	// 	}
	// },
	// {
	// 	path: '/link/view',
	// 	name: 'link_view',
	// 	component: () => import('../views/link/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接详情'
	// 	}
	// },

	// 轮播图路由
	{
		path: '/slides/table',
		name: 'slides_table',
		component: () => import('../views/slides/table.vue'),
		meta: {
			index: 0,
			title: '轮播图列表'
		}
	},
	{
		path: '/slides/view',
		name: 'slides_view',
		component: () => import('../views/slides/view.vue'),
		meta: {
			index: 0,
			title: '轮播图详情'
		}
	},
		// 文章路由
	{
		path: '/article/table',
		name: 'article_table',
		component: () => import('../views/article/table.vue'),
		meta: {
			index: 0,
			title: '文章列表'
		}
	},
	{
		path: '/article/view',
		name: 'article_view',
		component: () => import('../views/article/view.vue'),
		meta: {
			index: 0,
			title: '文章详情'
		}
	},

	// 文章分类路由
	{
		path: '/article_type/table',
		name: 'article_type_table',
		component: () => import('../views/article_type/table.vue'),
		meta: {
			index: 0,
			title: '文章分类列表'
		}
	},
	{
		path: '/article_type/view',
		name: 'article_type_view',
		component: () => import('../views/article_type/view.vue'),
		meta: {
			index: 0,
			title: '文章分类详情'
		}
	},
	
	// 广告路由
	// {
	// 	path: '/ad/table',
	// 	name: 'ad_table',
	// 	component: () => import('../views/ad/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告列表'
	// 	}
	// },
	// {
	// 	path: '/ad/view',
	// 	name: 'ad_view',
	// 	component: () => import('../views/ad/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告详情'
	// 	}
	// },



	// 公告路由
	{
		path: '/notice/table',
		name: 'notice_table',
		component: () => import('../views/notice/table.vue'),
		meta: {
			index: 0,
			title: '通知公告列表'
		}
	},
	{
		path: '/notice/view',
		name: 'notice_view',
		component: () => import('../views/notice/view.vue'),
		meta: {
			index: 0,
			title: '通知公告详情'
		}
	},


	// 评论路由
	{
		path: '/comment/table',
		name: 'comment_table',
		component: () => import('../views/comment/table.vue'),
		meta: {
			index: 0,
			title: '评论列表'
		}
	},
	{
		path: '/comment/view',
		name: 'comment_view',
		component: () => import('../views/comment/view.vue'),
		meta: {
			index: 0,
			title: '评论详情'
		}
	},

	// 运动员用户路由
	{
		path: '/athlete_users/table',
		name: 'athlete_users_table',
		component: () => import('../views/athlete_users/table.vue'),
		meta: {
			index: 0,
			title: '运动员用户列表'
		}
	},
	{
		path: '/athlete_users/view',
		name: 'athlete_users_view',
		component: () => import('../views/athlete_users/view.vue'),
		meta: {
			index: 0,
			title: '运动员用户详情'
		}
	},
	// 裁判员用户路由
	{
		path: '/referee_user/table',
		name: 'referee_user_table',
		component: () => import('../views/referee_user/table.vue'),
		meta: {
			index: 0,
			title: '裁判员用户列表'
		}
	},
	{
		path: '/referee_user/view',
		name: 'referee_user_view',
		component: () => import('../views/referee_user/view.vue'),
		meta: {
			index: 0,
			title: '裁判员用户详情'
		}
	},
	// 比赛信息路由
	{
		path: '/competition_information/table',
		name: 'competition_information_table',
		component: () => import('../views/competition_information/table.vue'),
		meta: {
			index: 0,
			title: '比赛信息列表'
		}
	},
	{
		path: '/competition_information/view',
		name: 'competition_information_view',
		component: () => import('../views/competition_information/view.vue'),
		meta: {
			index: 0,
			title: '比赛信息详情'
		}
	},
	// 报名信息路由
	{
		path: '/registration_information/table',
		name: 'registration_information_table',
		component: () => import('../views/registration_information/table.vue'),
		meta: {
			index: 0,
			title: '报名信息列表'
		}
	},
	{
		path: '/registration_information/view',
		name: 'registration_information_view',
		component: () => import('../views/registration_information/view.vue'),
		meta: {
			index: 0,
			title: '报名信息详情'
		}
	},
	// 取消信息路由
	{
		path: '/cancel_information/table',
		name: 'cancel_information_table',
		component: () => import('../views/cancel_information/table.vue'),
		meta: {
			index: 0,
			title: '取消信息列表'
		}
	},
	{
		path: '/cancel_information/view',
		name: 'cancel_information_view',
		component: () => import('../views/cancel_information/view.vue'),
		meta: {
			index: 0,
			title: '取消信息详情'
		}
	},
	// 成绩信息路由
	{
		path: '/score_information/table',
		name: 'score_information_table',
		component: () => import('../views/score_information/table.vue'),
		meta: {
			index: 0,
			title: '成绩信息列表'
		}
	},
	{
		path: '/score_information/view',
		name: 'score_information_view',
		component: () => import('../views/score_information/view.vue'),
		meta: {
			index: 0,
			title: '成绩信息详情'
		}
	},

	// 用户路由
	{
		path: '/user/table',
		name: 'user_table',
		component: () => import('../views/user/table.vue'),
		meta: {
			index: 0,
			title: '用户列表'
		}
	},
	{
		path: '/user/view',
		name: 'user_view',
		component: () => import('../views/user/view.vue'),
		meta: {
			index: 0,
			title: '用户详情'
		}
	},
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue'),
		meta: {
			index: 0,
			title: '个人信息'
		}
	},
	// 用户组路由
	{
		path: '/user_group/table',
		name: 'user_group_table',
		component: () => import('../views/user_group/table.vue'),
		meta: {
			index: 0,
			title: '用户组列表'
		}
	},
	{
		path: '/user_group/view',
		name: 'user_group_view',
		component: () => import('../views/user_group/view.vue'),
		meta: {
			index: 0,
			title: '用户组详情'
		}
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.beforeEach((to, from, next) => {
	let token = to.query.token;
	if (token){
		$.db.set("token",token,120);
	}
	next();
})

router.afterEach((to, from, next) => {
	let title = "高校体育运动会管理系统-admin";
	document.title = title;
})

export default router
