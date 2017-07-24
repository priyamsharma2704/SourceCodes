using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Security.Cryptography;

namespace PasswordEncryptor
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        static string Encrypt(string value)
        {
            /*
             * MD5 algo produces 128 bit hashvalue.
            Its a one way encryption technique
            its application is to store users passwords in DB in encrypted format so that it cant be read by unauthorised person
            MD5 always return same 16 bit string, so there is no need to decrypt it.
            We can again encrypt the password and match it with the encrypted password that we have with us.
            So this is the advantage of MD5 that it can not be decrypted.
            only the person who has encrypted it will know the password.
            */
            using (MD5CryptoServiceProvider md5 = new MD5CryptoServiceProvider())
            {
                UTF8Encoding utf = new UTF8Encoding();
                byte[] data = md5.ComputeHash(utf.GetBytes(value));
                return Convert.ToBase64String(data);
            }
        }

        private void click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(txtPassword.Text))
            {
                MessageBox.Show("Please enter the password", "Message", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            txtResult.Text = Encrypt(txtPassword.Text);
        }
    }
}
