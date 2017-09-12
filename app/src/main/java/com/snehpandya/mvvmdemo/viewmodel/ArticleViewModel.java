package com.snehpandya.mvvmdemo.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.snehpandya.mvvmdemo.BR;
import com.snehpandya.mvvmdemo.model.Article;

/**
 * Created by Sneh on 12-09-2017.
 */

public class ArticleViewModel extends BaseObservable {

    private Article mArticle;
    private Context mContext;

    public ArticleViewModel(Article article, Context context) {
        mArticle = article;
        mContext = context;
    }

    @Bindable
    public String getTitle() {
        return mArticle.getTitle();
    }

    public void setTitle(String title) {
        mArticle.setTitle(title);
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public int getCommentsNumber() {
        return mArticle.getCommentsNumber();
    }

    public void setCommentsNumber(int commentsNumber) {
        mArticle.setCommentsNumber(commentsNumber);
        notifyPropertyChanged(BR.commentsNumber);
    }

    @Bindable
    public boolean getRead() {
        return mArticle.isRead();
    }

    public void setRead(boolean read) {
        mArticle.setRead(read);
        notifyPropertyChanged(BR.read);
    }
}
