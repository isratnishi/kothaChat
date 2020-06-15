package com.opus_bd.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.opus_bd.myapplication.Activity.ChatActivity;
import com.opus_bd.myapplication.Model.User.UserListModel;
import com.opus_bd.myapplication.R;
import com.opus_bd.myapplication.Utils.Constants;
import com.opus_bd.myapplication.Utils.Utilities;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MemberListAdapter extends RecyclerView.Adapter<MemberListAdapter.TransactionViewHolder> {
    private final Context context;
    private List<UserListModel> items;


    public MemberListAdapter(List<UserListModel> items, Context context) {
        this.items = items;
        this.context = context;
    }


    @Override
    public TransactionViewHolder onCreateViewHolder(ViewGroup parent,
                                                    int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_list_view, parent, false);

        return new TransactionViewHolder(v);
    }


    @Override
    public void onBindViewHolder(TransactionViewHolder holder, int position) {
        UserListModel item = items.get(position);
        holder.set(item);
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    public class TransactionViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imgUser)
        ImageView ivUserImage;
        @BindView(R.id.tvProfileName)
        TextView tvProfileName;
        /*  @BindView(R.id.btnSendMessage)
          Button btnSendMessage;*/
        @BindView(R.id.rootLayout)
        LinearLayout rootLayout;


        public TransactionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void set(final UserListModel item) {
            //UI setting code

            tvProfileName.setText(String.valueOf(item.getName()));
            try {
                Glide.with(context)
                        .applyDefaultRequestOptions(new RequestOptions()
                                .placeholder(R.drawable.ic_person)
                                .error(R.drawable.ic_person))
                        .load(Constants.BASE_URL + item.getEmpPhoto())
                        .into(ivUserImage);
            } catch (Exception e) {
            }


            rootLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ChatActivity.class);
                    intent.putExtra(ChatActivity.EXTRA_RECEIVER_ID, item.getId());
                    Utilities.showLogcatMessage(" USER ID" + item.getId());
                    intent.putExtra(ChatActivity.EXTRA_RECEIVER_NAME, item.getName());
                    intent.putExtra(ChatActivity.EXTRA_RECEIVER_PHOTO, item.getEmpPhoto());
                    context.startActivity(intent);
                }
            });
          /*  btnSendMessage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ChatActivity.class);
                    intent.putExtra(ChatActivity.EXTRA_RECEIVER_ID, item.getId());
                    intent.putExtra(ChatActivity.EXTRA_RECEIVER_NAME, item.getName());
                    context.startActivity(intent);
                }
            });*/

        }


    }


}
