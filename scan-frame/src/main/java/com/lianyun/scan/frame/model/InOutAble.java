package com.lianyun.scan.frame.model;

public interface InOutAble<IN, OUT> {

	OUT toOut(IN in);

	IN toIn(OUT out);

}
