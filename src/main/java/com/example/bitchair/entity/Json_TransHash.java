package com.example.bitchair.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author nankex.
 * @data 2023/5/24.
 */
@NoArgsConstructor
@Data
public class Json_TransHash {

    private String hash;
    private Integer ver;
    private Integer vin_sz;
    private Integer vout_sz;
    private Integer size;
    private Integer weight;
    private Integer fee;
    private String relayed_by;
    private Integer lock_time;
    private Long tx_index;
    private Boolean double_spend;
    private Integer time;
    private Integer block_index;
    private Integer block_height;
    private List<InputsDTO> inputs;
    private List<OutDTO> out;

    @NoArgsConstructor
    @Data
    public static class InputsDTO {
        private Long sequence;
        private String witness;
        private String script;
        private Integer index;
        private PrevOutDTO prev_out;

        @NoArgsConstructor
        @Data
        public static class PrevOutDTO {
            private Long n;
            private String script;
            private List<SpendingOutpointsDTO> spending_outpoints;
            private Boolean spent;
            private String tx_index;
            private Integer type;
            private Integer value;
            private String addr;

            @NoArgsConstructor
            @Data
            public static class SpendingOutpointsDTO {
                private Integer n;
                private Long tx_index;
            }
        }
    }

    @NoArgsConstructor
    @Data
    public static class OutDTO {
        private Integer type;
        private Boolean spent;
        private Integer value;
        private List<SpendingOutpointsDTO> spending_outpoints;
        private Integer n;
        private Long tx_index;
        private String script;
        private String addr;

        @NoArgsConstructor
        @Data
        public static class SpendingOutpointsDTO {
            private Long tx_index;
            private Integer n;
        }
    }
}
