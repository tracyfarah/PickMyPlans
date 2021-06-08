package tracy.androidprojects.project2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder> {
    private String[] captions;
    private String[]descriptions;
    private int[] imageIds;
    private OnPlaceListener onPlaceListener;

    public CaptionedImagesAdapter(String[] captions, String[]descriptions, int[] imageIds, OnPlaceListener onPlaceListener) {
        this.captions = captions;
        this.descriptions = descriptions;
        this.imageIds = imageIds;
        this.onPlaceListener = onPlaceListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        OnPlaceListener onPlaceListener;
        public ViewHolder(@NonNull CardView cv, OnPlaceListener onPlaceListener) {
            super(cv);
            cardView = cv;
            this.onPlaceListener = onPlaceListener;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onPlaceListener.onPlaceClick(getAdapterPosition());
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_captioned_image, viewGroup, false);
        return new ViewHolder(cv, onPlaceListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        CardView cardView = viewHolder.cardView;
        ImageView imageView = cardView.findViewById(R.id.info_image_view);
        imageView.setImageResource(imageIds[position]);
        TextView nameTextView = cardView.findViewById(R.id.name_text_view);
        nameTextView.setText(captions[position]);
        TextView descTextView = cardView.findViewById(R.id.description_text_view);
        descTextView.setText(descriptions[position]);
    }

    @Override
    public int getItemCount() {
        return captions.length;
    }

    public interface OnPlaceListener{
        void onPlaceClick(int position);
    }

}
