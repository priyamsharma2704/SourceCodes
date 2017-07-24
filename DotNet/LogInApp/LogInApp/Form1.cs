using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace LogInApp
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void txtUserNameKeyPress(object sender, KeyPressEventArgs e)
        {
            if(e.KeyChar == (char)13)
            {
                txtUserName.Focus();
            }
        }

        private void txtPasswordKeyPress(object sender, KeyPressEventArgs e)
        {
            if(e.KeyChar == (char)13)
            {
                btnLogin.PerformClick();
            }
        }

        private void btnLoginClick(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(txtUserName.Text))
            {
                MessageBox.Show("Please enter a user name.", "Message", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                txtUserName.Focus();
                return;
            }
            try
            {
                logindbDataSetTableAdapters.usersTableAdapter user = new logindbDataSetTableAdapters.usersTableAdapter();
                logindbDataSet.usersDataTable dt = user.Login(txtUserName.Text, txtPassword.Text);
                if(dt.Rows.Count > 0)
                {
                    MessageBox.Show("You have successfully logged in", "Message", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    txtUserName.Clear();
                    txtPassword.Clear();
                }
                else
                {
                    MessageBox.Show("Invalid username password", "Message", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
            }
            catch(Exception ex)
            {
                MessageBox.Show(ex.Message, "Message", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
    }
}
