package moe.minori.pgpclipper.util;

/**
 * Created by Minori on 2015-09-26.
 */
public class PGPBlockDetector {

    private static final String PGP_SIGNEDMSG_START = "-----BEGIN PGP SIGNED MESSAGE-----";
    private static final String PGP_SIGNEDMSG_END = "-----END PGP SIGNATURE-----";

    private static final String PGP_MESSAGE_START = "-----BEGIN PGP MESSAGE-----";
    private static final String PGP_MESSAGE_END = "-----END PGP MESSAGE-----";

    public static boolean isBlockPresent (String input)
    {
        if ( input != null )
        {
            if ( input.contains(PGP_SIGNEDMSG_START) && input.contains(PGP_SIGNEDMSG_END) ) // signature message with plain text
            {
                return true;
            }
            else if ( input.contains(PGP_MESSAGE_START) && input.contains(PGP_MESSAGE_END) ) // encrypted message (possibly signed)
            {
                return true;
            }
            else // no pgp data
            {
                return false;
            }
        }
        else // text is null
            return false;

    }
}
