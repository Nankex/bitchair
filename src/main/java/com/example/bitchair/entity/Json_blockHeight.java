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
public class Json_blockHeight {
    private List<BlocksDTO> blocks;

    @NoArgsConstructor
    @Data
    public static class BlocksDTO {
        private String hash;
        private Integer ver;
        private String prev_block;
        private String mrkl_root;
        private Integer time;
        private Integer bits;
        private List<String> next_block;
        private Integer fee;
        private String nonce;
        private Integer n_tx;
        private Integer size;
        private Integer block_index;
        private Boolean main_chain;
        private Integer height;
        private Integer weight;
        private List<TxDTO> tx;

        @NoArgsConstructor
        @Data
        public static class TxDTO {
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
                    private String value;
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
                private Long value;
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
    }
}
