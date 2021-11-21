package com.forfun.eventalert.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001 B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001c\u0010\u0017\u001a\u00020\u000f2\n\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0013H\u0017J\u001c\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J\u0018\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0013H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/forfun/eventalert/adapters/EventListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/forfun/eventalert/adapters/EventListAdapter$ViewHolder;", "mContext", "Lcom/forfun/eventalert/activities/MainActivity;", "data", "", "Lcom/forfun/eventalert/models/webapiModels/EventContent;", "(Lcom/forfun/eventalert/activities/MainActivity;Ljava/util/List;)V", "isClosed", "", "()Z", "setClosed", "(Z)V", "deleteEvent", "", "eventId", "", "getItemCount", "", "isShowContent", "view", "Landroid/view/View;", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateProcessingStatus", "status", "ViewHolder", "app_debug"})
public final class EventListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.forfun.eventalert.adapters.EventListAdapter.ViewHolder> {
    private boolean isClosed;
    private final com.forfun.eventalert.activities.MainActivity mContext = null;
    private final java.util.List<com.forfun.eventalert.models.webapiModels.EventContent> data = null;
    
    public final boolean isClosed() {
        return false;
    }
    
    public final void setClosed(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.forfun.eventalert.adapters.EventListAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.forfun.eventalert.adapters.EventListAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    private final void updateProcessingStatus(java.lang.String eventId, int status) {
    }
    
    private final void deleteEvent(java.lang.String eventId) {
    }
    
    private final void isShowContent(android.view.View view) {
    }
    
    public EventListAdapter(@org.jetbrains.annotations.NotNull()
    com.forfun.eventalert.activities.MainActivity mContext, @org.jetbrains.annotations.NotNull()
    java.util.List<com.forfun.eventalert.models.webapiModels.EventContent> data) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001c\u0010&\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010 \"\u0004\b(\u0010\"R\u001c\u0010)\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\u001c\u0010,\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R\u001c\u0010/\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010 \"\u0004\b1\u0010\"\u00a8\u00062"}, d2 = {"Lcom/forfun/eventalert/adapters/EventListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/forfun/eventalert/adapters/EventListAdapter;Landroid/view/View;)V", "btnCancel", "Landroid/widget/Button;", "getBtnCancel", "()Landroid/widget/Button;", "setBtnCancel", "(Landroid/widget/Button;)V", "btnFinish", "getBtnFinish", "setBtnFinish", "btnProcessing", "getBtnProcessing", "setBtnProcessing", "cardView", "Landroidx/cardview/widget/CardView;", "getCardView", "()Landroidx/cardview/widget/CardView;", "setCardView", "(Landroidx/cardview/widget/CardView;)V", "tvBadge", "Landroid/widget/ImageView;", "getTvBadge", "()Landroid/widget/ImageView;", "setTvBadge", "(Landroid/widget/ImageView;)V", "tvContent", "Landroid/widget/TextView;", "getTvContent", "()Landroid/widget/TextView;", "setTvContent", "(Landroid/widget/TextView;)V", "tvProcessing", "getTvProcessing", "setTvProcessing", "tvRealContent", "getTvRealContent", "setTvRealContent", "tvStatus", "getTvStatus", "setTvStatus", "tvTime", "getTvTime", "setTvTime", "tvTitle", "getTvTitle", "setTvTitle", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.Nullable()
        private android.widget.TextView tvTitle;
        @org.jetbrains.annotations.Nullable()
        private android.widget.TextView tvContent;
        @org.jetbrains.annotations.Nullable()
        private android.widget.TextView tvProcessing;
        @org.jetbrains.annotations.Nullable()
        private android.widget.Button btnProcessing;
        @org.jetbrains.annotations.Nullable()
        private android.widget.Button btnFinish;
        @org.jetbrains.annotations.Nullable()
        private android.widget.Button btnCancel;
        @org.jetbrains.annotations.Nullable()
        private androidx.cardview.widget.CardView cardView;
        @org.jetbrains.annotations.Nullable()
        private android.widget.ImageView tvBadge;
        @org.jetbrains.annotations.Nullable()
        private android.widget.TextView tvStatus;
        @org.jetbrains.annotations.Nullable()
        private android.widget.TextView tvTime;
        @org.jetbrains.annotations.Nullable()
        private android.widget.TextView tvRealContent;
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.TextView getTvTitle() {
            return null;
        }
        
        public final void setTvTitle(@org.jetbrains.annotations.Nullable()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.TextView getTvContent() {
            return null;
        }
        
        public final void setTvContent(@org.jetbrains.annotations.Nullable()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.TextView getTvProcessing() {
            return null;
        }
        
        public final void setTvProcessing(@org.jetbrains.annotations.Nullable()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.Button getBtnProcessing() {
            return null;
        }
        
        public final void setBtnProcessing(@org.jetbrains.annotations.Nullable()
        android.widget.Button p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.Button getBtnFinish() {
            return null;
        }
        
        public final void setBtnFinish(@org.jetbrains.annotations.Nullable()
        android.widget.Button p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.Button getBtnCancel() {
            return null;
        }
        
        public final void setBtnCancel(@org.jetbrains.annotations.Nullable()
        android.widget.Button p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final androidx.cardview.widget.CardView getCardView() {
            return null;
        }
        
        public final void setCardView(@org.jetbrains.annotations.Nullable()
        androidx.cardview.widget.CardView p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.ImageView getTvBadge() {
            return null;
        }
        
        public final void setTvBadge(@org.jetbrains.annotations.Nullable()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.TextView getTvStatus() {
            return null;
        }
        
        public final void setTvStatus(@org.jetbrains.annotations.Nullable()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.TextView getTvTime() {
            return null;
        }
        
        public final void setTvTime(@org.jetbrains.annotations.Nullable()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.TextView getTvRealContent() {
            return null;
        }
        
        public final void setTvRealContent(@org.jetbrains.annotations.Nullable()
        android.widget.TextView p0) {
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}