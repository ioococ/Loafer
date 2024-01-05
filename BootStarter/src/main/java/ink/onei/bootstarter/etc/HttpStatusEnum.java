package ink.onei.bootstarter.etc;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 03/01/2024 11:09 Wednesday
 */

public enum HttpStatusEnum {
    error_404 {
        public String Json() {
            return "{ \"code\": \"404\"}";
        }
    },

    error_401 {
        public String Json() {
            return "{ \"code\": \"401\"}";
        }
    },
    error_403 {
        public String Json() {
            return "{ \"code\": \"403\"}";
        }
    },
    error_500 {
        public String Json() {
            return "{ \"code\": \"500\"}";
        }
    },
}
