using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ContactsApp
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        private void contactsTableBindingNavigatorSaveItem_Click_2(object sender, EventArgs e)
        {
            this.Validate();
            this.contactsTableBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.contactsTableDataSet);

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'contactsTableDataSet.ContactsTable' table. You can move, or remove it, as needed.
            this.contactsTableTableAdapter.Fill(this.contactsTableDataSet.ContactsTable);
            //contactsTableBindingSource.AddNew();
        }

        private void btnSave_Click(object sender, EventArgs e)
        {            
            try
            {
                this.Validate();
                this.contactsTableBindingSource.EndEdit();
                this.tableAdapterManager.UpdateAll(this.contactsTableDataSet);
                MessageBox.Show("Data has been saved", "Information", MessageBoxButtons.OK);
                contactsTableBindingSource.AddNew();
                firstNameTextBox.Select();

            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);                                    
            }
        }

        private void btnNew_Click(object sender, EventArgs e)
        {
            try
            {
                contactsTableBindingSource.AddNew();
                
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }

        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            DialogResult dialogResult = MessageBox.Show("Are you sure to delete?",
                      "Delete?", MessageBoxButtons.YesNo);
            switch (dialogResult)
            {
                case DialogResult.Yes:
                    {
                        try
                        {
                            contactsTableBindingSource.RemoveCurrent();
                        }
                        catch (Exception ex)
                        {
                            MessageBox.Show(ex.Message);                           
                        }
                        break;
                    }
                    
                case DialogResult.No:
                    {

                        break;
                    }
            }

        }

        private void btnBack_Click(object sender, EventArgs e)
        {
            contactsTableBindingSource.MovePrevious();
        }

        private void btnForward_Click(object sender, EventArgs e)
        {
            contactsTableBindingSource.MoveNext();
        }
    }
}
