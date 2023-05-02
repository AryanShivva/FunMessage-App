# FunMessage-App

Creating my adapter and using it for ListView in kotlin.

<img width="368" alt="Screenshot 2023-05-02 at 11 00 15 PM" src="https://user-images.githubusercontent.com/124916476/235741173-921ee0a1-14ef-49ea-aaad-67fcce5ecaab.png"><img width="361" alt="Screenshot 2023-05-02 at 11 02 07 PM" src="https://user-images.githubusercontent.com/124916476/235741187-20456744-51b9-48bc-af80-b8bc41c66310.png">



MainActivity.kt File Code : 

    class MainActivity : AppCompatActivity() {

    lateinit var userArrayList : ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val name = arrayOf("Aryan(You)","Allu Arjun","Ambani","Sundar Pichai","Elon Musk","Murthy","Shanthan","Tate","Sai","Jayesh")
        val lastMsg = arrayOf("done","deal ok Aryan","call back Aryan","ok","What's the next plan Aryan?","hey","ok bro","Thank u Aryan","hi","enjoy")
        val lastMsgTime = arrayOf("9.00PM","8.30PM","8.01PM","4.09PM","3.30PM","1.10PM","11.00AM","7.05AM","6.00AM","yesterday")
        val phoneNumber = arrayOf("8688376361","8788604999","8347944923", "9489390348","9309333222","8522864065","9652057128","9999999999","9550961561","8074565238")
        val imgId = intArrayOf(R.drawable.pic5,R.drawable.pic4,R.drawable.pic3,R.drawable.pic2,R.drawable.pic1,R.drawable.pic12,R.drawable.pic6,R.drawable.pic8,R.drawable.pic20,R.drawable.pic13,)

        userArrayList=ArrayList()

        for (eachIndex in name.indices){
            val user = User(name[eachIndex], lastMsg[eachIndex],lastMsgTime[eachIndex],phoneNumber[eachIndex]
            ,imgId[eachIndex])

           userArrayList.add(user)
        }

        val listView = findViewById<ListView>(R.id.listView)
        listView.isClickable = true
        listView.adapter = MyAdapter(this,userArrayList)

        listView.setOnItemClickListener{ parent, view, position , id ->
            //open a new activity
            val username = name[position]
            val userphone = phoneNumber[position]
            val imageId = imgId[position]

            val i = Intent(this,UserActivity::class.java)

            i.putExtra("name",username)
            i.putExtra("phone",userphone)
            i.putExtra("imageId",imageId)
            startActivity(i)
        }



    }
    }
    
    
    
Adapter.kt File Code : 

    class MyAdapter (private val context : Activity, private val arrayList:ArrayList<User>) :
        ArrayAdapter<User>(context, R.layout.eachitem,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.eachitem, null)

        val image = view.findViewById<CircleImageView>(R.id.profile_image)
        val name = view.findViewById<TextView>(R.id.tVName)
        val lastMsg = view.findViewById<TextView>(R.id.tVLastMessage)
        val lastMsgTime = view.findViewById<TextView>(R.id.tVLastMsgTime)

        name.text = arrayList[position].name
        lastMsg.text = arrayList[position].lastMsg
        lastMsgTime.text = arrayList[position].lastMsgTime
        image.setImageResource(arrayList[position].imageId)

        return view

    }
    }
    
    
Intent to show another screen.

UserActivity.kt File Code : 

    class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        supportActionBar?.hide()
        // what we are taking from the precious screen

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val imageid = intent.getIntExtra("imageId",R.drawable.pic5)

        val nameTv = findViewById<TextView>(R.id.tVName)
        val phoneTv = findViewById<TextView>(R.id.tVPhone)
        val image = findViewById<CircleImageView>(R.id.profile_image)

        //setting
        nameTv.text = name
        phoneTv.text = phone
        image.setImageResource(imageid)

    }
    }


