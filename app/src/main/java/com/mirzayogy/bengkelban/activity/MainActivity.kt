package com.mirzayogy.bengkelban.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.mirzayogy.bengkelban.R
import com.mirzayogy.bengkelban.adapter.GridBengkelAdapter
import com.mirzayogy.bengkelban.adapter.ListBengkelAdapter
import com.mirzayogy.bengkelban.data.BengkelData
import com.mirzayogy.bengkelban.model.Bengkel

class MainActivity : AppCompatActivity() {

    private lateinit var rvCategory: RecyclerView
    private var list: ArrayList<Bengkel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCategory = findViewById(R.id.rv_category)
        rvCategory.setHasFixedSize(true)

        list.addAll(BengkelData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvCategory.layoutManager = LinearLayoutManager(this)
        val listBengkelAdapter = ListBengkelAdapter(this,list)
        rvCategory.adapter = listBengkelAdapter

        listBengkelAdapter.onItemClickListener = { bengkel ->
            showSelectedBengkel(bengkel)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                showRecyclerList()
            }
            R.id.action_grid -> {
                showRecyclerGrid();
            }
            R.id.action_cardview -> {
            }
        }
    }

    private fun showSelectedBengkel(bengkel: Bengkel) {
        Toast.makeText(this, "Kamu memilih " + bengkel.name, Toast.LENGTH_SHORT).show()
    }

    private fun showRecyclerGrid() {
        rvCategory.layoutManager = GridLayoutManager(this, 3)
        val gridHeroAdapter = GridBengkelAdapter(this,list)
        rvCategory.adapter = gridHeroAdapter
    }
}
