package com.kpu.dao;

import java.io.FileInputStream;

import org.springframework.stereotype.Repository;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.kpu.domain.UserVO;

@Repository
public class FirebaseDAOImpl implements FirebaseDAO {
	public static final String COLLECTION_NAME = "Users";
	/*
	public void initialize() throws Exception{
		try {
			FileInputStream serviceAccount =
					  new FileInputStream("src/main/resources/serviceAccountKey.json");

					FirebaseOptions options = new FirebaseOptions.Builder()
					  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
					  .setDatabaseUrl("https://graduation-4bd4f-default-rtdb.firebaseio.com")
					  .build();

					FirebaseApp.initializeApp(options);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	*/
	
	public UserVO selectUser(String id) throws Exception{
		/*
		Firestore firestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = firestore.collection(COLLECTION_NAME).document(id);
		ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
		DocumentSnapshot documentSnapshot = apiFuture.get();
		UserVO user = null;
		if(documentSnapshot.exists()) {
			user = documentSnapshot.toObject(UserVO.class);
			System.out.println(user.toString());
			return user;
		}else {
			return null;
		}
		*/
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(id);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();
		UserVO Uvo = null;
		
		if(document.exists()) {
			Uvo = document.toObject(UserVO.class);
			return Uvo;
		}
		else {
			return null;
		}
	}



	@Override
	public String insertUser(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
