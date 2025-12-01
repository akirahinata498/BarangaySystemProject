package BarangayManagementSystem;

public class CertificateStatus {
    public void dismissedCertificate(CertificateRequest certificateRequest) {
            System.out.println(certificateRequest.toString() + "\n\n");

        System.out.println("Reason: " + certificateRequest.getReason() + "\n\n");
        System.out.println("Please contact the barangay office for assistance");
        System.out.println("====================================================");
    }

    public void pendingCertificate(CertificateRequest certificateRequest) {
        System.out.println(certificateRequest.toString() + "\n\n");

        System.out.println("Your certificate is currently being reviewed");
        System.out.println("Please wait for further updates");
        System.out.println("====================================================");
    }

        public void approvedCertificate(CertificateRequest certificateRequest) {
        System.out.println(certificateRequest.toString() + "\n\n");

        System.out.println("This is to certify that the above-named individual is a");
        System.out.println("bonafide resident of Barangay Sampaguita and has no");
        System.out.println("derogatory records on file as of the date issued.\n\n");
        System.out.println("Issued and signed by:");
        System.out.println("Hon. Ramon Montenegro.\n\n");
        System.out.println("====================================================");
    }
}
