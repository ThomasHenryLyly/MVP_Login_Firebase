package teo.android.mvplogin.model;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ModelLogin {

    private ModelListener modelListener;

    public ModelLogin(ModelListener modelListener) {
        this.modelListener = modelListener;
    }

    public void handle(final String user, final String password)
    {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserModel model = snapshot.getValue(UserModel.class);
                if (model.getUser().equals(user) && model.getPass().equals(password))
                {
                    modelListener.modelSuccess();
                }else{
                    modelListener.modelFailed();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
