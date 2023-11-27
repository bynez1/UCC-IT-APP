package com.example.admin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FacultyStaffActivity : AppCompatActivity(), FacultyStaffAdapter.OnItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FacultyStaffAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculty_staff)

        // Initialize the RecyclerView, adapter, and layout manager
        recyclerView = findViewById(R.id.faculty_staff_recycler_view)
        adapter = FacultyStaffAdapter(getFacultyStaffMembers(), this)
        layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

        adapter.setOnItemClickListener(object : FacultyStaffAdapter.OnItemClickListener {
            override fun onItemClick(staffMember: FacultyStaffMember) {
                val position = layoutManager.findFirstVisibleItemPosition()
                val imageView = recyclerView.findViewHolderForAdapterPosition(position)
                    ?.itemView?.findViewById<ImageView>(R.id.imageView)
                imageView?.setImageResource(staffMember.imageResId)
            }

            override fun onEmailClick(staffMember: FacultyStaffMember) {
                // You can use staffMember.email to get the email address here
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:${staffMember.email}")
                }
                startActivity(intent)
            }

            override fun onPhoneClick(phoneNumber: String) {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(intent)
            }
        })


    }

    private fun getFacultyStaffMembers(): List<FacultyStaffMember> {
        return listOf(
            FacultyStaffMember(
                "",
                "Ms. Natalie Rose",
                "IT Head of Department",
                R.drawable.natalie,
                "123-456-7890",
                "ithod@ucc.edu.jm"
            ),
            FacultyStaffMember(
                "",
                "Mr. Julian Francis",
                "IT Lecturer",
                R.drawable.julian,
                "987-654-3210",
                "jafrancis@faculty.ucc.edu.jm"
            ),
            FacultyStaffMember(
                "",
                "Mr. Henry Osborne",
                "IT Lecturer",
                R.drawable.osbourne,
                "555-555-5555",
                "hosborne@ucc.edu.jm"
            ),
            FacultyStaffMember(
                "",
                "Mr. Neil Williams",
                "IT Lecturer",
                R.drawable.neil,
                "987-654-3210",
                "nwilliams@ucc.edu.jm"
            ),
            FacultyStaffMember(
                "",
                "Mr. Ricardo Reid",
                "Programme Officer",
                R.drawable.ricardo,
                "555-555-5555",
                "itprogrammeofficer3@ucc.edu.jm"
            ),
            FacultyStaffMember(
                "",
                "Mr. Otis Osbourne",
                "IT Lecturer/Asst. Programme Coordinator",
                R.drawable.otis,
                "111-222-3333",
                "itfaculty@ucc.edu.jm"
            )
        )
    }

    override fun onItemClick(staffMember: FacultyStaffMember) {

        onPhoneClick(staffMember.phoneNumber)
    }

    override fun onEmailClick(staffMember: FacultyStaffMember) {
        // Do nothing if email is clicked in the activity
    }

    override fun onPhoneClick(phoneNumber: String) {
        // Do nothing if phone number is clicked in the activity
    }
}


