package com.forfun.IssueConsole.models.webapiModels;

import java.util.List;

public class LoginResponse extends BaseModel {

    /**
     * content : {"userid":"00001","username":"陳某某","appId":[1,2,4,10],"token":"(Guid)","factoryId":["工廠ID","工廠ID"],"factoryName":["工廠名稱","工廠名稱"],"rankId":"職級ID","rankName":"職級名稱","deptId":"部門ID","deptName":"部門名稱"}
     */

    private ContentBean content;

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * userid : 00001
         * username : 陳某某
         * appId : [1,2,4,10]
         * token : (Guid)
         * factoryId : ["工廠ID","工廠ID"]
         * factoryName : ["工廠名稱","工廠名稱"]
         * rankId : 職級ID
         * rankName : 職級名稱
         * deptId : 部門ID
         * deptName : 部門名稱
         */

        private String userId;
        private String username;
        private String token;
        private String rankId;
        private String rankName;
        private String deptId;
        private String deptName;
        private List<Integer> appId;
        private List<String> factoryId;
        private List<String> factoryName;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getRankId() {
            return rankId;
        }

        public void setRankId(String rankId) {
            this.rankId = rankId;
        }

        public String getRankName() {
            return rankName;
        }

        public void setRankName(String rankName) {
            this.rankName = rankName;
        }

        public String getDeptId() {
            return deptId;
        }

        public void setDeptId(String deptId) {
            this.deptId = deptId;
        }

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public List<Integer> getAppId() {
            return appId;
        }

        public void setAppId(List<Integer> appId) {
            this.appId = appId;
        }

        public List<String> getFactoryId() {
            return factoryId;
        }

        public void setFactoryId(List<String> factoryId) {
            this.factoryId = factoryId;
        }

        public List<String> getFactoryName() {
            return factoryName;
        }

        public void setFactoryName(List<String> factoryName) {
            this.factoryName = factoryName;
        }
    }
}
