<template>
  <div class="page_search">
	<div class="warp">
	  <div class="container">
		<div class="row">
		  <div class="col-12">
			<div class="card_result_search">
			  <div class="title">搜索结果</div>

				<!-- 文章搜索结果 -->
			  <list_result_search
				:list="result_article"
				title="宣传资讯"
				source_table="article"
			  ></list_result_search>


						  <list_result_search
				v-if="$check_action('/athlete_users/list', 'get')"
				:list="result_athlete_users_athletes"
				title="运动员用户运动员"
				source_table="athlete_users"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/athlete_users/list', 'get')"
				:list="result_athlete_users_gender"
				title="运动员用户性别"
				source_table="athlete_users"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/athlete_users/list', 'get')"
				:list="result_athlete_users_age"
				title="运动员用户年龄"
				source_table="athlete_users"
			  ></list_result_search>
									  <list_result_search
				v-if="$check_action('/referee_user/list', 'get')"
				:list="result_referee_user_referee_name"
				title="裁判员用户裁判姓名"
				source_table="referee_user"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/referee_user/list', 'get')"
				:list="result_referee_user_gender_of_referee"
				title="裁判员用户裁判性别"
				source_table="referee_user"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/referee_user/list', 'get')"
				:list="result_referee_user_age_of_referee"
				title="裁判员用户裁判年龄"
				source_table="referee_user"
			  ></list_result_search>
												  <list_result_search
				v-if="$check_action('/competition_information/list', 'get')"
				:list="result_competition_information_entry_name"
				title="比赛信息项目名称"
				source_table="competition_information"
			  ></list_result_search>
											  <list_result_search
				v-if="$check_action('/competition_information/list', 'get')"
				:list="result_competition_information_competition_classification"
				title="比赛信息比赛分类"
				source_table="competition_information"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/competition_information/list', 'get')"
				:list="result_competition_information_competition_time"
				title="比赛信息比赛时间"
				source_table="competition_information"
			  ></list_result_search>
																														  <list_result_search
				v-if="$check_action('/registration_information/list', 'get')"
				:list="result_registration_information_athletes"
				title="报名信息运动员"
				source_table="registration_information"
			  ></list_result_search>
																	  <list_result_search
				v-if="$check_action('/registration_information/list', 'get')"
				:list="result_registration_information_entry_name"
				title="报名信息项目名称"
				source_table="registration_information"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/registration_information/list', 'get')"
				:list="result_registration_information_competition_classification"
				title="报名信息比赛分类"
				source_table="registration_information"
			  ></list_result_search>
																											  <list_result_search
				v-if="$check_action('/cancel_information/list', 'get')"
				:list="result_cancel_information_athletes"
				title="取消信息运动员"
				source_table="cancel_information"
			  ></list_result_search>
																	  <list_result_search
				v-if="$check_action('/cancel_information/list', 'get')"
				:list="result_cancel_information_entry_name"
				title="取消信息项目名称"
				source_table="cancel_information"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/cancel_information/list', 'get')"
				:list="result_cancel_information_competition_classification"
				title="取消信息比赛分类"
				source_table="cancel_information"
			  ></list_result_search>
																																	  <list_result_search
				v-if="$check_action('/score_information/list', 'get')"
				:list="result_score_information_athletes"
				title="成绩信息运动员"
				source_table="score_information"
			  ></list_result_search>
														  <list_result_search
				v-if="$check_action('/score_information/list', 'get')"
				:list="result_score_information_project_number"
				title="成绩信息项目编号"
				source_table="score_information"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/score_information/list', 'get')"
				:list="result_score_information_entry_name"
				title="成绩信息项目名称"
				source_table="score_information"
			  ></list_result_search>
																		</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
</template>

<script>
import mixin from "../../mixins/page.js";
import list_result_search from "../../components/diy/list_result_search.vue";

export default {
  mixins: [mixin],
  data() {
	return {
	  "query": {
		word: "",
	  },
	  "result_article": [],
						"result_athlete_users_athletes":[],
								"result_athlete_users_gender":[],
								"result_athlete_users_age":[],
									"result_referee_user_referee_name":[],
								"result_referee_user_gender_of_referee":[],
								"result_referee_user_age_of_referee":[],
												"result_competition_information_entry_name":[],
											"result_competition_information_competition_classification":[],
								"result_competition_information_competition_time":[],
																														"result_registration_information_athletes":[],
																	"result_registration_information_entry_name":[],
								"result_registration_information_competition_classification":[],
																											"result_cancel_information_athletes":[],
																	"result_cancel_information_entry_name":[],
								"result_cancel_information_competition_classification":[],
																																	"result_score_information_athletes":[],
														"result_score_information_project_number":[],
								"result_score_information_entry_name":[],
																};
  },
  methods: {
	/**
	 * 获取文章
	 */
	get_article() {
	  this.$get("~/api/article/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_article = json.result.list;
		}
	  });
	},

				/**
	 * 获取athletes
	 */
	get_athlete_users_athletes(){
		let url = "~/api/athlete_users/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "athletes": this.query.word }, (json) => {
		  if (json.result) {
			var result_athlete_users_athletes = json.result.list;
			result_athlete_users_athletes.map(o => o.title = o['athletes'])
	  			this.result_athlete_users_athletes = result_athlete_users_athletes
		 	}
		});
	},
						/**
	 * 获取gender
	 */
	get_athlete_users_gender(){
		let url = "~/api/athlete_users/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "gender": this.query.word }, (json) => {
		  if (json.result) {
			var result_athlete_users_gender = json.result.list;
			result_athlete_users_gender.map(o => o.title = o['gender'])
	  			this.result_athlete_users_gender = result_athlete_users_gender
		 	}
		});
	},
						/**
	 * 获取age
	 */
	get_athlete_users_age(){
		let url = "~/api/athlete_users/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "age": this.query.word }, (json) => {
		  if (json.result) {
			var result_athlete_users_age = json.result.list;
			result_athlete_users_age.map(o => o.title = o['age'])
	  			this.result_athlete_users_age = result_athlete_users_age
		 	}
		});
	},
							/**
	 * 获取referee_name
	 */
	get_referee_user_referee_name(){
		let url = "~/api/referee_user/get_list?like=0";
				url = url+"&examine_state=已通过";
				this.$get(url, { page: 1, size: 10, "referee_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_referee_user_referee_name = json.result.list;
			result_referee_user_referee_name.map(o => o.title = o['referee_name'])
	  			this.result_referee_user_referee_name = result_referee_user_referee_name
		 	}
		});
	},
						/**
	 * 获取gender_of_referee
	 */
	get_referee_user_gender_of_referee(){
		let url = "~/api/referee_user/get_list?like=0";
				url = url+"&examine_state=已通过";
				this.$get(url, { page: 1, size: 10, "gender_of_referee": this.query.word }, (json) => {
		  if (json.result) {
			var result_referee_user_gender_of_referee = json.result.list;
			result_referee_user_gender_of_referee.map(o => o.title = o['gender_of_referee'])
	  			this.result_referee_user_gender_of_referee = result_referee_user_gender_of_referee
		 	}
		});
	},
						/**
	 * 获取age_of_referee
	 */
	get_referee_user_age_of_referee(){
		let url = "~/api/referee_user/get_list?like=0";
				url = url+"&examine_state=已通过";
				this.$get(url, { page: 1, size: 10, "age_of_referee": this.query.word }, (json) => {
		  if (json.result) {
			var result_referee_user_age_of_referee = json.result.list;
			result_referee_user_age_of_referee.map(o => o.title = o['age_of_referee'])
	  			this.result_referee_user_age_of_referee = result_referee_user_age_of_referee
		 	}
		});
	},
										/**
	 * 获取entry_name
	 */
	get_competition_information_entry_name(){
		let url = "~/api/competition_information/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "entry_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_competition_information_entry_name = json.result.list;
			result_competition_information_entry_name.map(o => o.title = o['entry_name'])
	  			this.result_competition_information_entry_name = result_competition_information_entry_name
		 	}
		});
	},
									/**
	 * 获取competition_classification
	 */
	get_competition_information_competition_classification(){
		let url = "~/api/competition_information/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "competition_classification": this.query.word }, (json) => {
		  if (json.result) {
			var result_competition_information_competition_classification = json.result.list;
			result_competition_information_competition_classification.map(o => o.title = o['competition_classification'])
	  			this.result_competition_information_competition_classification = result_competition_information_competition_classification
		 	}
		});
	},
						/**
	 * 获取competition_time
	 */
	get_competition_information_competition_time(){
		let url = "~/api/competition_information/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "competition_time": this.query.word }, (json) => {
		  if (json.result) {
			var result_competition_information_competition_time = json.result.list;
			result_competition_information_competition_time.map(o => o.title = o['competition_time'])
	  			this.result_competition_information_competition_time = result_competition_information_competition_time
		 	}
		});
	},
																												/**
	 * 获取athletes
	 */
	get_registration_information_athletes(){
		let url = "~/api/registration_information/get_list?like=0";
				url = url+"&examine_state=已通过";
				this.$get(url, { page: 1, size: 10, "athletes": this.query.word }, (json) => {
		  if (json.result) {
			var result_registration_information_athletes = json.result.list;
			result_registration_information_athletes.map(o => o.title = o['athletes'])
	  			this.result_registration_information_athletes = result_registration_information_athletes
		 	}
		});
	},
															/**
	 * 获取entry_name
	 */
	get_registration_information_entry_name(){
		let url = "~/api/registration_information/get_list?like=0";
				url = url+"&examine_state=已通过";
				this.$get(url, { page: 1, size: 10, "entry_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_registration_information_entry_name = json.result.list;
			result_registration_information_entry_name.map(o => o.title = o['entry_name'])
	  			this.result_registration_information_entry_name = result_registration_information_entry_name
		 	}
		});
	},
						/**
	 * 获取competition_classification
	 */
	get_registration_information_competition_classification(){
		let url = "~/api/registration_information/get_list?like=0";
				url = url+"&examine_state=已通过";
				this.$get(url, { page: 1, size: 10, "competition_classification": this.query.word }, (json) => {
		  if (json.result) {
			var result_registration_information_competition_classification = json.result.list;
			result_registration_information_competition_classification.map(o => o.title = o['competition_classification'])
	  			this.result_registration_information_competition_classification = result_registration_information_competition_classification
		 	}
		});
	},
																									/**
	 * 获取athletes
	 */
	get_cancel_information_athletes(){
		let url = "~/api/cancel_information/get_list?like=0";
				url = url+"&examine_state=已通过";
				this.$get(url, { page: 1, size: 10, "athletes": this.query.word }, (json) => {
		  if (json.result) {
			var result_cancel_information_athletes = json.result.list;
			result_cancel_information_athletes.map(o => o.title = o['athletes'])
	  			this.result_cancel_information_athletes = result_cancel_information_athletes
		 	}
		});
	},
															/**
	 * 获取entry_name
	 */
	get_cancel_information_entry_name(){
		let url = "~/api/cancel_information/get_list?like=0";
				url = url+"&examine_state=已通过";
				this.$get(url, { page: 1, size: 10, "entry_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_cancel_information_entry_name = json.result.list;
			result_cancel_information_entry_name.map(o => o.title = o['entry_name'])
	  			this.result_cancel_information_entry_name = result_cancel_information_entry_name
		 	}
		});
	},
						/**
	 * 获取competition_classification
	 */
	get_cancel_information_competition_classification(){
		let url = "~/api/cancel_information/get_list?like=0";
				url = url+"&examine_state=已通过";
				this.$get(url, { page: 1, size: 10, "competition_classification": this.query.word }, (json) => {
		  if (json.result) {
			var result_cancel_information_competition_classification = json.result.list;
			result_cancel_information_competition_classification.map(o => o.title = o['competition_classification'])
	  			this.result_cancel_information_competition_classification = result_cancel_information_competition_classification
		 	}
		});
	},
																															/**
	 * 获取athletes
	 */
	get_score_information_athletes(){
		let url = "~/api/score_information/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "athletes": this.query.word }, (json) => {
		  if (json.result) {
			var result_score_information_athletes = json.result.list;
			result_score_information_athletes.map(o => o.title = o['athletes'])
	  			this.result_score_information_athletes = result_score_information_athletes
		 	}
		});
	},
												/**
	 * 获取project_number
	 */
	get_score_information_project_number(){
		let url = "~/api/score_information/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "project_number": this.query.word }, (json) => {
		  if (json.result) {
			var result_score_information_project_number = json.result.list;
			result_score_information_project_number.map(o => o.title = o['project_number'])
	  			this.result_score_information_project_number = result_score_information_project_number
		 	}
		});
	},
						/**
	 * 获取entry_name
	 */
	get_score_information_entry_name(){
		let url = "~/api/score_information/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "entry_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_score_information_entry_name = json.result.list;
			result_score_information_entry_name.map(o => o.title = o['entry_name'])
	  			this.result_score_information_entry_name = result_score_information_entry_name
		 	}
		});
	},
															
  },
  components: { list_result_search },
	created(){
    this.query.word = this.$route.query.word || "";
  },
  mounted() {
	this.get_article();
					this.get_athlete_users_athletes();
							this.get_athlete_users_gender();
							this.get_athlete_users_age();
								this.get_referee_user_referee_name();
							this.get_referee_user_gender_of_referee();
							this.get_referee_user_age_of_referee();
											this.get_competition_information_entry_name();
										this.get_competition_information_competition_classification();
							this.get_competition_information_competition_time();
																													this.get_registration_information_athletes();
																this.get_registration_information_entry_name();
							this.get_registration_information_competition_classification();
																										this.get_cancel_information_athletes();
																this.get_cancel_information_entry_name();
							this.get_cancel_information_competition_classification();
																																this.get_score_information_athletes();
													this.get_score_information_project_number();
							this.get_score_information_entry_name();
															  },
  watch: {
	$route() {
	  $.push(this.query, this.$route.query);
	  this.get_article();
				  this.get_athlete_users_athletes();
						  this.get_athlete_users_gender();
						  this.get_athlete_users_age();
							  this.get_referee_user_referee_name();
						  this.get_referee_user_gender_of_referee();
						  this.get_referee_user_age_of_referee();
										  this.get_competition_information_entry_name();
									  this.get_competition_information_competition_classification();
						  this.get_competition_information_competition_time();
																												  this.get_registration_information_athletes();
															  this.get_registration_information_entry_name();
						  this.get_registration_information_competition_classification();
																									  this.get_cancel_information_athletes();
															  this.get_cancel_information_entry_name();
						  this.get_cancel_information_competition_classification();
																															  this.get_score_information_athletes();
												  this.get_score_information_project_number();
						  this.get_score_information_entry_name();
																},
  },
};
</script>

<style scoped>
.card_search {
  text-align: center;
}
.card_result_search>.title {
  text-align: center;
  padding: 10px 0;
}
</style>
