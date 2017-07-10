package im.akari.gittracer.util;

/**
 * Created by akari on 2017/6/16.
 */

public enum Status {
    //新建态
    newly,
    //正在初始化
    initing,
    //初始化失败
    initFail,
    //初始化成功
    initSuccess,
    //考试正在进行
    ongoing,
    //考试时间到
    timeup,
    //正在分析结果
    analyzing,
    //结果分析完毕
    analyzingFinish
}
