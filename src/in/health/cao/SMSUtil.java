package in.health.cao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.TwilioRestResponse;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.AvailablePhoneNumber;
import com.twilio.sdk.resource.instance.Call;
import com.twilio.sdk.resource.instance.Conference;
import com.twilio.sdk.resource.instance.Participant;
import com.twilio.sdk.resource.list.AccountList;
import com.twilio.sdk.resource.list.AvailablePhoneNumberList;
import com.twilio.sdk.resource.list.ParticipantList;
import com.twilio.sdk.verbs.TwiMLException;

public class SMSUtil {

  public static final String ACCOUNT_SID = 	"ACed2a462cb35ce3238d9240d68204316a";
  public static final String AUTH_TOKEN = "cbfd19ab7be29602537c9936a4ec0af1";

  public static void sendSMS(String mobile_number, String message) throws TwilioRestException, TwiMLException {

    // Create a rest client
    final TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

    // Get the main account (The one we used to authenticate the client)
    final Account mainAccount = client.getAccount();

    // Get all accounts including sub accounts
    AccountList accountList = client.getAccounts();

    // All lists implement an iterable interface, you can use the foreach
    // syntax on them
    for (final Account a : accountList) {
      System.out.println(a.getFriendlyName());
    }

    // You can also iterate manually...
    final Iterator<Account> itr = accountList.iterator();
    while (itr.hasNext()) {
      final Account a = itr.next();
      System.out.println(a.getFriendlyName());
    }

    // You can also get just the first page of data
    accountList = client.getAccounts();
    final List<Account> accounts = accountList.getPageData();

    /*
    // Make a call
    final CallFactory callFactory = mainAccount.getCallFactory();
    final Map<String, String> callParams = new HashMap<String, String>();
    callParams.put("To", "5105551212"); // Replace with a valid phone number
    callParams.put("From", "(510) 555-1212"); // Replace with a valid phone number in your account
    callParams.put("Url", "http://demo.twilio.com/welcome/voice/");
    final Call call = callFactory.create(callParams);
    System.out.println(call.getSid());


*/
    // Send an sms
    final SmsFactory smsFactory = mainAccount.getSmsFactory();
    final Map<String, String> smsParams = new HashMap<String, String>();
    smsParams.put("To", mobile_number); // Replace with a valid phone number +918884314202
    smsParams.put("From", "(442) 333-7093"); // Replace with a valid phone number in your account +1 442-333-7093
    smsParams.put("Body", message);
    smsFactory.create(smsParams);

    
    /*
    // Search for available phone numbers & then buy a random phone number
    final AvailablePhoneNumberList phoneNumbers = mainAccount.getAvailablePhoneNumbers();
    final List<AvailablePhoneNumber> list = phoneNumbers.getPageData();

    // Buy the first number returned
    final Map<String, String> params = new HashMap<String, String>();
    params.put("PhoneNumber", list.get(0).getPhoneNumber());
    params.put("VoiceUrl", "http://demo.twilio.com/welcome/voice/");
    mainAccount.getIncomingPhoneNumberFactory().create(params);

    // View a conference using its sid
    final Conference c = mainAccount.getConference("CA12345...");
    final ParticipantList participants = c.getParticipants();

    for (final Participant p : participants) {
      // Randomly mute or kick each participant
      if (Math.random() > 0.5) {
        p.mute();
      } else {
        p.kick();
      }
    }

    // Make a raw HTTP request to the api... note, this is deprecated style
    final TwilioRestResponse resp = client.request("/2010-04-01/Accounts", "GET", null);
    if (!resp.isError()) {
      System.out.println(resp.getResponseText());
    }
    
    */
  }
  
  public static void main(String args[]) throws TwilioRestException, TwiMLException {
	  
	sendSMS("+918884314202", "Social worker Bose has invited u to join UDHC network");
  }
}