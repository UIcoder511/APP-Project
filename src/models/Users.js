const Users = {
  user_id,
  password,
  security_ques,
  security_ans,

  get userId() {
    return this.user_id;
  },

  set userId(userId) {
    this.userId = userId;
  },

  get password() {
    return this.password;
  },

  set password(pwd) {
    this.password = pwd;
  },

  get security_ques() {
    return this.security_ques;
  },

  set security_ques(securityQues) {
    this.security_ques = securityQues;
  },

  get security_ans() {
    return this.security_ans;
  },

  set security_ans(securityAns) {
    this.security_ans = securityAns;
  },
};
