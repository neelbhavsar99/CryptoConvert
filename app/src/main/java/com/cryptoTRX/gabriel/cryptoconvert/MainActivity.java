package com.cryptoTRX.gabriel.cryptoconvert;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button click;
    public static TextView data;
    public static double value;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    public  static String[] factsarray= {" Bitcoin processes electronic payments which is system based on cryptographic proof, to protect all parties", "Today, there are over 20,915,750 million bitcoins in circulation with a total market value of $165,101,334,800 billion", "Satoshi Nakamoto proposed a solution to the double spending problem using a peer-to-peer distributed timestamp server to generate computational proof of the chronological order of transactions","A Bitcoin is incapable to counterfeit because of the cryptographic proof security feature"," Bitcoin is a peer-to-peer version of electronic cash which would allow online payments to be sent directly from one party to another without going through a financial institution"," A defining feature of a Bitcoin, and arguably its most endearing allure, is its organic nature; it is not issued by any central authority, rendering it immune to third-party interference or a single administrator"," Nobody can steal your personal information, which ensures the privacy of your sensitive data","By creating a proxy ID, you can make sure that no one knows anything about you"," General public have easy access to them by digital and virtual means"," All you need is the address wallet of the person or enterprise to whom you wish to make the payment"," Cryptocurrency holders will be able to buy Bitcoins with hard cash or sell and convert Bitcoins into traditional cash"," You are the master of your money","The amount will credit the receiver’s account immediately and without delay"," The ease of transfer and the low transaction fees makes it very desirable","A transaction will be secure as it is using NSA created cryptography"," It is next to impossible for any person other than the owner of the digital wallet to make any payment from his or her digital wallet","You don’t need to share your identity, your whereabouts or the details of the transactions made between you and the beneficiary","No information needs to be shared with the government and/or a bank regarding the deal. It is truly decentralized"," Costs Less – Compared to credit card processing fees, the costs are negligible","Once you made the payment, you cannot chargeback","The inter-country transaction is extremely easy with Bitcoin; because its function is not under the control of any central bank","Bitcoin is the first cryptocurrency to have launched, in the year 2009 by an individual or group known under the pseudonym Satoshi Nakamoto","Unlike other forms of currency, Bitcoin makes it easier to transfer funds between two parties in a transaction because you can’t touch it, smell it, or put it in a safe","Bitcoin uses blockchain technology to store and share an online ledger of all updated and approved bitcoin"," defining feature of Ethereum is its smart contract feature, that protects all parties source, data, and transmitted information","The second largest cryptocurrency next to Bitcoin in market value is Ethereum"," Ethereum is also a blockchain-based platform to create real-world applications, apply programming, projects, and transfer data, or properties"," Vitallik Buterin is the creator and founder of Ethereum, which went live in 2014-15","Enter the amount of Ether to transfer from the sender to the recipient, by making payment processing more efficient"," Ethereum blockchain contains a copy of the transaction list and the most recent state of the transaction validation","The Ethereum network can underpin Decentralized file storage such as escrow payments, data feed and digital assets – all run as programmed in an infinite loop "," Just like Bitcoin the supply growth rate of Ether over time tends to zero, meaning the long-term supply growth rate can last up to 100 years"," Ethereum protocol is open to all developers that may add complexity solutions to its optimization","Litecoin is derived from the bitcoin blockchain"," Litecoin is an instant, near zero cost payment network and peer-to-peer cryptocurrency ","Litecoin transaction system is decentralized and secured by cryptographic algorithms preventing double spending and chance of fraud"," A cryptocurrency holder may transfer, send or receive Litecoin payments to and from a public user worldwide instantly","The details of the Litecoin payment – including its source, destination and data – are added to what is referred to as a block"};
    public static EditText currencyValue;
    public static TextView convertedValueToUse;
//        FetchData classToUse = new FetchData();
    public FetchData myDataObj = new FetchData();
    int localSelection;
    int localSelectionDest;
    public static TextView factstr;
    Thread thread = new Thread()
    {

        @Override
        public void run() {
            try {
                while (!thread.isInterrupted()) {
                    Thread.sleep(1000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            myDataObj = new FetchData();

                            if(localSelection == 1 && localSelectionDest == 1)
                                myDataObj.whichURL = 1;
                            if(localSelection == 1 && localSelectionDest == 2)
                                myDataObj.whichURL = 2;
                            if(localSelection == 1 && localSelectionDest == 3)
                                myDataObj.whichURL = 3;
                            if(localSelection == 2 && localSelectionDest == 1)
                                myDataObj.whichURL = 4;
                            if(localSelection == 2 && localSelectionDest == 2)
                                myDataObj.whichURL = 5;
                            if(localSelection == 2 && localSelectionDest == 3)
                                myDataObj.whichURL = 6;
                            if(localSelection == 3 && localSelectionDest == 1)
                                myDataObj.whichURL = 7;
                            if(localSelection == 3 && localSelectionDest == 2)
                                myDataObj.whichURL = 8;
                            if(localSelection == 3 && localSelectionDest == 3)
                                myDataObj.whichURL = 9;
                            myDataObj.execute();
                            //myDataObj.cancel(true);

                        }
                    });
                }
            }
            catch (InterruptedException e)
            {

            }
        }
    };
    public  void openTerms()
    {
        Intent intent = new Intent(this,termsActivity.class);
        startActivity(intent);
    }

    public  void openSupport()
    {
        Intent intent = new Intent(this,supportActivity.class);
        startActivity(intent);
    }

    public  void openHome()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = findViewById(R.id.clickBtn);

        data = findViewById(R.id.oneBTC);

        currencyValue = findViewById(R.id.currencyVal);
        convertedValueToUse = findViewById(R.id.convertedVal);
        factstr=findViewById(R.id.factsText);
        thread.start();
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                myDataObj.btnClickCall();


            }
        });

        drawerLayout= findViewById(R.id.drawer_layout);
        navigationView= findViewById(R.id.navigationView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.icon_home :
                        menuItem.setChecked(true);
                        openHome();
                        //drawerLayout.closeDrawers();
                        break;

                    case R.id.icon_support:
                        menuItem.setChecked(true);
                        openSupport();
                       // drawerLayout.closeDrawers();
                        break;
                    case R.id.icon_terms:
                        menuItem.setChecked(true);
                        openTerms();
                        //drawerLayout.closeDrawers();
                        break;


                }




                return false;
            }
        });

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.currencyoptions,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
//-------------------------------------------
        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.crptooptions,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        String text  = parent.getItemAtPosition(position).toString();
//        FetchData classToUse = new FetchData();
        //myDataObj.strURL = "https://min-api.cryptocompare.com/data/price?fsym=CAD&tsyms=BTC,ETH&extraParams=your_app_name";
        localSelection = 1;
        if(text.equals("CAD"))
        {
            localSelection = 1;

        }
        else  if (text.equals("EUR"))
        {
            localSelection = 3;

        }
        else if(text.equals("USD"))
        {
            localSelection = 2;
        }

        else if(text.equals("ETH"))
        {
            localSelectionDest = 1;

        }
        else  if (text.equals("BTC"))
        {
            localSelectionDest = 2;

        }
        else if(text.equals("LTC"))
        {
            localSelectionDest = 3;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}