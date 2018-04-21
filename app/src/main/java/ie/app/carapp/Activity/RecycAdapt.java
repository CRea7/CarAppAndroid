//package ie.app.carapp.Activity;
//
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Parcel;
//import android.provider.SyncStateContract;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.google.android.gms.common.internal.Constants;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import ie.app.carapp.R;
//import ie.app.carapp.models.Car;
//
//public class RecycAdapt extends RecyclerView.ViewHolder implements View.OnClickListener{
//
//    private static final int MAX_WIDTH = 200;
//    private static final int MAX_HEIGHT = 200;
//
//    private View mView;
//    private Context context;
//
//    public RecycAdapt(View itemView) {
//        super(itemView);
//        mView = itemView;
//        context = itemView.getContext();
//        itemView.setOnClickListener(this);
//    }
//
//    public void onBindViewHolder(Car car) {
//
//        TextView Cname = mView.findViewById(R.id.RecName);
//        TextView Cmake = mView.findViewById(R.id.RecMake);
//        TextView Cyear = mView.findViewById(R.id.RecYear);
//
//        Cname.setText(car.getCarname());
//        Cmake.setText(car.getCarMake());
//        Cyear.setText(car.getCarYear());
//    }
//
//    @Override
//    public void onClick(View view) {
//
//        final ArrayList<Car> cars = new ArrayList<>();
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
//                    cars.add(snapshot.getValue(Car.class));
//                }
//
//                int itemPosition = getLayoutPosition();
//
//                Intent intent = new Intent(context, MainActivity.class);
//                intent.putExtra("position", itemPosition + "");
//                //intent.putExtra("cars", Parcels.wrap(cars));
//
//                context.startActivity(intent);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//    }
//
//}

