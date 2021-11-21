package com.forfun.IssueConsole.models.webapiModels;

public class VersionCheckResponse {

    /**
     * msg :
     * code : 200
     * content : {"NowVersion":"","ForceUpdate":false,"Url":""}
     */

    private String msg;
    private int code;
    private ContentBean content;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * NowVersion :
         * ForceUpdate : false
         * Url :
         */

        private String NowVersion;
        private boolean ForceUpdate;
        private String Url;

        public String getNowVersion() {
            return NowVersion;
        }

        public void setNowVersion(String NowVersion) {
            this.NowVersion = NowVersion;
        }

        public boolean isForceUpdate() {
            return ForceUpdate;
        }

        public void setForceUpdate(boolean ForceUpdate) {
            this.ForceUpdate = ForceUpdate;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String Url) {
            this.Url = Url;
        }
    }
}
