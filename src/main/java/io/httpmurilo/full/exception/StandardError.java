package io.httpmurilo.full.exception;

import java.io.Serializable;

public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;

    public StandardError(Long timestamp, Integer status, String mensagem) {
        this.timestamp = timestamp;
        this.status = status;
        this.mensagem = mensagem;
    }

    private Long timestamp;
    private Integer status;
    private String mensagem;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
