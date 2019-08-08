//unduh twitter4j di http://twitter4j.org/en/index.html
//masukkan ke project     
//twitter4j-async-a.b.c.jar
//    twitter4j-core-a.b.c.jar
//    twitter4j-media-support-a.b.c.jar
//    twitter4j-stream-a.b.c.jar
//ubah consumer key, consumer key secret, access token, access token secret sesuai akun twitter anda


import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY = "7P15wo3fl5o2OO7eFbVcGxEtn";
    private final static String CONSUMER_KEY_SECRET = "lGz45wKDHHPXJmppPgwwWKucguftXy9Mzs7GdEKYZ0yST12kvg";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Hi, your welcome");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "xRUYZVK85p44KsRqZnWnr98sN3OFgF5PvYS6qr6JBx2ZE";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "1150387974451814400-Y4jNZ9IqdrjaDgH7J8U2dqcr39p0Wk";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}