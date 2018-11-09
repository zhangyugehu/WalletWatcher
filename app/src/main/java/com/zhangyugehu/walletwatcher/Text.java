package com.zhangyugehu.walletwatcher;


import java.util.ArrayList;
import java.util.List;

public class Text {
    interface BaseView{

    }

    static class AView implements BaseView{

    }

    static abstract class BasePresenter<V extends BaseView>{
        V view;
    }

    static class APresenter extends BasePresenter<AView>{

    }

}
