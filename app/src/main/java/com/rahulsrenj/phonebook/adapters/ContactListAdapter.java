    package com.rahulsrenj.phonebook.adapters;

    import android.content.Context;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;

    import androidx.annotation.NonNull;
    import androidx.databinding.DataBindingUtil;
    import androidx.recyclerview.widget.RecyclerView;

    import com.rahulsrenj.phonebook.viewmodel.ContactsViewModel;
    import com.rahulsrenj.phonebook.utils.ItemClickListener;
    import com.rahulsrenj.phonebook.R;
    import com.rahulsrenj.phonebook.database.Contacts;
    import com.rahulsrenj.phonebook.databinding.ContactItemLayoutBinding;

    import java.util.ArrayList;

    public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ViewHolder> {
        private ContactItemLayoutBinding binding;
        private ArrayList<Contacts> contactsArrayList;
        private Context context;

        private ItemClickListener clickListener;
        private ContactsViewModel viewModel;

        public void setClickListener(ItemClickListener clickListener){
            this.clickListener=clickListener;
        }
        public ContactListAdapter(Context context,ArrayList<Contacts> contactsArrayList,ContactsViewModel viewModel) {
            this.context=context;
            this.contactsArrayList = contactsArrayList;
            this.viewModel=viewModel;

        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            binding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.contact_item_layout,parent,false);
            return new ViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Contacts currentContact=contactsArrayList.get(position);
            holder.binding.setContacts(currentContact);
            holder.binding.setViewModel(viewModel);
            holder.binding.executePendingBindings();
        }

        @Override
        public int getItemCount() {
            if(contactsArrayList!=null){
                return contactsArrayList.size();
            }
            return 0;
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            private ContactItemLayoutBinding binding;

            public ViewHolder(ContactItemLayoutBinding binding) {
                super(binding.getRoot());
                this.binding=binding;
                binding.getRoot().setOnClickListener(this);

            }

            @Override
            public void onClick(View view) {
                if(clickListener!=null){
                    clickListener.onItemClicked(view,getAdapterPosition(),contactsArrayList.get(getAdapterPosition()));
                }
            }
        }
    }
