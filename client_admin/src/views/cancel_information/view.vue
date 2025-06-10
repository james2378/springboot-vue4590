<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','athlete_account') || $check_field('add','athlete_account') || $check_field('set','athlete_account')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="运动员账号" prop="athlete_account">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_athlete_account(form['athlete_account']) }}
							<!--<el-input id="business_name" v-model="form['athlete_account']" placeholder="请输入运动员账号"-->
							<!--v-if="user_group === '管理员' || (form['cancel_information_id'] && $check_field('set','athlete_account')) || (!form['cancel_information_id'] && $check_field('add','athlete_account'))" :disabled="disabledObj['athlete_account_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','athlete_account')">{{form['athlete_account']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['cancel_information_id'] && $check_field('set','athlete_account')) || (!form['cancel_information_id'] && $check_field('add','athlete_account'))" id="athlete_account" v-model="form['athlete_account']" :disabled="disabledObj['athlete_account_isDisabled']">
								<el-option v-for="o in list_user_athlete_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','athlete_account')" id="athlete_account" v-model="form['athlete_account']" :disabled="true">
								<el-option v-for="o in list_user_athlete_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="athlete_account" v-model="form['athlete_account']" :disabled="disabledObj['athlete_account_isDisabled']">
							<el-option v-for="o in list_user_athlete_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','athletes') || $check_field('add','athletes') || $check_field('set','athletes')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="运动员" prop="athletes">
												<el-input id="athletes" v-model="form['athletes']" placeholder="请输入运动员"
							  v-if="user_group === '管理员' || (form['cancel_information_id'] && $check_field('set','athletes')) || (!form['cancel_information_id'] && $check_field('add','athletes'))" :disabled="disabledObj['athletes_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','athletes')">{{form['athletes']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','gender') || $check_field('add','gender') || $check_field('set','gender')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="性别" prop="gender">
												<el-input id="gender" v-model="form['gender']" placeholder="请输入性别"
							  v-if="user_group === '管理员' || (form['cancel_information_id'] && $check_field('set','gender')) || (!form['cancel_information_id'] && $check_field('add','gender'))" :disabled="disabledObj['gender_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','gender')">{{form['gender']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','age') || $check_field('add','age') || $check_field('set','age')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="年龄" prop="age">
								<el-input-number id="age" v-model.number="form['age']"
						v-if="user_group === '管理员' || (form['cancel_information_id'] && $check_field('set','age')) || (!form['cancel_information_id'] && $check_field('add','age'))" :disabled="disabledObj['age_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','age')">{{form['age']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','project_number') || $check_field('add','project_number') || $check_field('set','project_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目编号" prop="project_number">
												<el-input id="project_number" v-model="form['project_number']" placeholder="请输入项目编号"
							  v-if="user_group === '管理员' || (form['cancel_information_id'] && $check_field('set','project_number')) || (!form['cancel_information_id'] && $check_field('add','project_number'))" :disabled="disabledObj['project_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','project_number')">{{form['project_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','entry_name') || $check_field('add','entry_name') || $check_field('set','entry_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目名称" prop="entry_name">
												<el-input id="entry_name" v-model="form['entry_name']" placeholder="请输入项目名称"
							  v-if="user_group === '管理员' || (form['cancel_information_id'] && $check_field('set','entry_name')) || (!form['cancel_information_id'] && $check_field('add','entry_name'))" :disabled="disabledObj['entry_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','entry_name')">{{form['entry_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','competition_classification') || $check_field('add','competition_classification') || $check_field('set','competition_classification')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="比赛分类" prop="competition_classification">
												<el-input id="competition_classification" v-model="form['competition_classification']" placeholder="请输入比赛分类"
							  v-if="user_group === '管理员' || (form['cancel_information_id'] && $check_field('set','competition_classification')) || (!form['cancel_information_id'] && $check_field('add','competition_classification'))" :disabled="disabledObj['competition_classification_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','competition_classification')">{{form['competition_classification']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','competition_time') || $check_field('add','competition_time') || $check_field('set','competition_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="比赛时间" prop="competition_time">
								<el-date-picker :disabled="disabledObj['competition_time_isDisabled']" v-if="user_group === '管理员' || (form['cancel_information_id'] && $check_field('set','competition_time')) || (!form['cancel_information_id'] && $check_field('add','competition_time'))" id="competition_time"
						v-model="form['competition_time']" type="datetime" placeholder="选择日期时间">
					</el-date-picker>
					<div v-else-if="$check_field('get','competition_time')">{{form['competition_time']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','referee_account') || $check_field('add','referee_account') || $check_field('set','referee_account')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="裁判账号" prop="referee_account">
													<el-select v-if="user_group === '管理员' || (form['cancel_information_id'] && $check_field('set','referee_account')) || (!form['cancel_information_id'] && $check_field('add','referee_account'))" id="referee_account" v-model="form['referee_account']" :disabled="disabledObj['referee_account_isDisabled']">
							<el-option v-for="o in list_user_referee_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','referee_account')" id="referee_account" v-model="form['referee_account']" :disabled="true">
							<el-option v-for="o in list_user_referee_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','referee_name') || $check_field('add','referee_name') || $check_field('set','referee_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="裁判姓名" prop="referee_name">
												<el-input id="referee_name" v-model="form['referee_name']" placeholder="请输入裁判姓名"
							  v-if="user_group === '管理员' || (form['cancel_information_id'] && $check_field('set','referee_name')) || (!form['cancel_information_id'] && $check_field('add','referee_name'))" :disabled="disabledObj['referee_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','referee_name')">{{form['referee_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','number_of_cancellations') || $check_field('add','number_of_cancellations') || $check_field('set','number_of_cancellations')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="取消人数" prop="number_of_cancellations">
								<el-input-number id="number_of_cancellations" v-model.number="form['number_of_cancellations']"
						v-if="user_group === '管理员' || (form['cancel_information_id'] && $check_field('set','number_of_cancellations')) || (!form['cancel_information_id'] && $check_field('add','number_of_cancellations'))" :disabled="disabledObj['number_of_cancellations_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','number_of_cancellations')">{{form['number_of_cancellations']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','reason_for_cancellation') || $check_field('add','reason_for_cancellation') || $check_field('set','reason_for_cancellation')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="取消原因" prop="reason_for_cancellation">
								<el-input type="textarea" id="reason_for_cancellation" v-model="form['reason_for_cancellation']" placeholder="请输入取消原因"
						v-if="user_group === '管理员' || (form['cancel_information_id'] && $check_field('set','reason_for_cancellation')) || (!form['cancel_information_id'] && $check_field('add','reason_for_cancellation'))" :disabled="disabledObj['reason_for_cancellation_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','reason_for_cancellation')">{{form['reason_for_cancellation']}}</div>
							</el-form-item>
			</el-col>
							<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="审核状态" prop="examine_state">
					<el-select id="examine_state" v-model="form['examine_state']"
						v-if="user_group === '管理员' || (form['examine_state'] && $check_examine()) || (!form['examine_state'] && $check_examine())">
						<el-option key="未审核" label="未审核" value="未审核"></el-option>
						<el-option key="已通过" label="已通过" value="已通过"></el-option>
						<el-option key="未通过" label="未通过" value="未通过"></el-option>
					</el-select>
					<div v-else>{{form["examine_state"]}}</div>
				</el-form-item>
			</el-col>
					<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="审核回复" prop="examine_reply">
					<el-input id="examine_reply" v-model="form['examine_reply']" placeholder="请输入审核回复"
						v-if="user_group === '管理员' || (form['examine_reply'] && $check_examine()) || (!form['examine_reply'] && $check_examine())"></el-input>
					<div v-else>{{form["examine_reply"]}}</div>
				</el-form-item>
			</el-col>
	
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "cancel_information_id",
				url_add: "~/api/cancel_information/add?",
				url_set: "~/api/cancel_information/set?",
				url_get_obj: "~/api/cancel_information/get_obj?",
				url_upload: "~/api/cancel_information/upload?",

				query: {
					"cancel_information_id": 0,
				},

				form: {
								"athlete_account": 0, // 运动员账号
										"athletes":  '', // 运动员
										"gender":  '', // 性别
										"age":  0, // 年龄
										"project_number":  '', // 项目编号
										"entry_name":  '', // 项目名称
										"competition_classification":  '', // 比赛分类
										"competition_time":  '', // 比赛时间
										"referee_account": 0, // 裁判账号
										"referee_name":  '', // 裁判姓名
										"number_of_cancellations":  0, // 取消人数
										"reason_for_cancellation":  '', // 取消原因
									"examine_state": "未审核",
							"examine_reply": "",
							"cancel_information_id": 0, // ID
						
				},
				disabledObj:{
								"athlete_account_isDisabled": false,
										"athletes_isDisabled": false,
										"gender_isDisabled": false,
					          			"age_isDisabled": false,
										"project_number_isDisabled": false,
										"entry_name_isDisabled": false,
										"competition_classification_isDisabled": false,
										"competition_time_isDisabled": false,
										"referee_account_isDisabled": false,
										"referee_name_isDisabled": false,
					          			"number_of_cancellations_isDisabled": false,
										"reason_for_cancellation_isDisabled": false,
										},

	
					// 用户列表
				list_user_athlete_account: [],
						// 用户组
				group_user_athlete_account: "",
				
		
		
		
		
		
		
		
					// 用户列表
				list_user_referee_account: [],
				
		
		
	
			}
		},
		methods: {


	
	
				/**
			 * 获取运动员用户用户列表
			 */
			async get_list_user_athlete_account() {
                // if(this.user_group !== "管理员" && this.form["athlete_account"] === 0) {
                //     this.form["athlete_account"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=运动员用户");
                if(json.result && json.result.list){
                    this.list_user_athlete_account = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					/**
			 * 获取运动员用户用户组
			 */
			async get_group_user_athlete_account() {
							this.form["athlete_account"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=运动员用户");
				if(json.result && json.result.obj){
					this.group_user_athlete_account = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_athlete_account(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_athlete_account.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
									for (let key in _this.form) {
							arrForm.push(key)
						}
												_this.form["athlete_account"] = id
									_this.disabledObj['athlete_account' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "athlete_account") {
			                      _this.form[arrForm[j]] = res.result.obj[arr[i]]
			                      _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								  break;
								} else {
								  _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								}
							  }
							}
						  }
						}
					}
				});
			},
					get_user_athlete_account(id){
				var obj = this.list_user_athlete_account.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
	
			
	
			
	
			
	
			
	
			
	
			
	
				/**
			 * 获取裁判员用户用户列表
			 */
			async get_list_user_referee_account() {
                // if(this.user_group !== "管理员" && this.form["referee_account"] === 0) {
                //     this.form["referee_account"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=裁判员用户");
                if(json.result && json.result.list){
                    this.list_user_referee_account = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					get_user_referee_account(id){
				var obj = this.list_user_referee_account.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
													// 获取缓存数据附加
				form = $.db.get("form");
							$.push(this.form ,form);
											
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
															        if (this.form["competition_time"].indexOf("-")===-1){
            this.form["competition_time"] = this.$toTime(parseInt(this.form["competition_time"]),"yyyy-MM-dd hh:mm:ss")
        }
														$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


																						        if(this.form["competition_time"]=="0000-00-00 00:00:00"){
          this.form["competition_time"] = null;
        }
				if(parseInt(this.form["competition_time"]) > 9999){
					this.form["competition_time"] = this.$toTime(parseInt(this.form["competition_time"]),"yyyy-MM-dd hh:mm:ss")
				}
															


			},

			/**
			 * 提交前验证事件
			 * @param {Object} 请求参数
			 * @return {String} 验证成功返回null, 失败返回错误提示
			 */
			submit_check(param) {
				let msg = null
																																										return msg;
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/cancel_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/cancel_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/cancel_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/cancel_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/cancel_information/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
					this.get_list_user_athlete_account();
					this.get_group_user_athlete_account();
																						this.get_list_user_referee_account();
											},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
