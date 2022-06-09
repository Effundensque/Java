package testing;

import eu.ase.test.Plane;
import eu.ase.test.PlaneCargo;
import eu.ase.test.PlaneDAO;
import eu.ase.test.PlaneUtils;
import eu.ase.test.TCPServerSocketMultiT;
import eu.ase.test.UDPClientSocket;
import eu.ase.test.UDPServerSocket;
import eu.ase.test.VectThread;
import eu.ase.test.Vehicle;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JUnitEvaluation {
	@Test
	public void _310testInfoClassBase_mark3() throws Exception {
		Class<?> t = Class.forName("eu.ase.test.Plane");
		if (t.getDeclaredFields().length < 3) {
			Assert.fail("Not proper number of the fields");
		}

		Field[] var5;
		int var4 = (var5 = t.getDeclaredFields()).length;

		for (int var3 = 0; var3 < var4; ++var3) {
			Field f = var5[var3];

			try {
				Assert.assertTrue("The field " + f.toString() + " is private", Modifier.isPrivate(f.getModifiers()));
				if (f.getName().compareTo("weight") == 0) {
					Assert.assertEquals("The 'weight' is type float", Float.TYPE, f.getType());
				}

				if (f.getName().compareTo("producer") == 0) {
					Assert.assertEquals("The field 'producer' is String", String.class, f.getType());
				}

				if (f.getName().compareTo("price") == 0) {
					Assert.assertEquals("The 'price' is type double", Double.TYPE, f.getType());
				}
			} catch (Exception var7) {
				Assert.fail("The field " + f.toString() + " has problems in class Plane.");
			}
		}

	}

	@Test
	public void _311testInfoClassInh_mark3() throws Exception {
		Class<?> t = Class.forName("eu.ase.test.PlaneCargo");
		if (t.getDeclaredFields().length < 1) {
			Assert.fail("Not proper number of the fields");
		}

		Field[] var5;
		int var4 = (var5 = t.getDeclaredFields()).length;

		for (int var3 = 0; var3 < var4; ++var3) {
			Field f = var5[var3];

			try {
				Assert.assertTrue("The field " + f.toString() + " is private", Modifier.isPrivate(f.getModifiers()));
				if (f.getName().compareTo("weight") == 0) {
					Assert.assertEquals("The 'weight' is type float", Float.TYPE, f.getType());
				}

				if (f.getName().compareTo("producer") == 0) {
					Assert.assertEquals("The field 'producer' is String", String.class, f.getType());
				}

				if (f.getName().compareTo("price") == 0) {
					Assert.assertEquals("The 'price' is type double", Double.TYPE, f.getType());
				}

				if (f.getName().compareTo("capacity") == 0) {
					Assert.assertEquals("The 'capacity' is type int", Float.TYPE, f.getType());
				}

				if (f.getName().compareTo("packagesWeight") == 0) {
					Assert.assertEquals("The 'packagesWeight' is type Float[]", Float[].class, f.getType());
				}
			} catch (Exception var7) {
				Assert.fail("The field " + f.toString() + " has problems in class PlaneCargo.");
			}
		}

	}

	@Test
	public void _312testSetProducer_mark3() throws Exception {
		Plane t = new Plane();
		t.setProducer("prod");
		Assert.assertEquals("prod", t.getProducer());
		t.setProducer("prod1");
		Assert.assertEquals("prod1", t.getProducer());
		t.setProducer("prod2");
		Assert.assertEquals("prod2", t.getProducer());
	}

	@Test
	public void _313testSetProducerException_mark3() {
		Plane t = new Plane();

		try {
			t.setProducer("a");
			Assert.fail("setProducer accepts ONLY ONE CHAR");
		} catch (Exception var5) {
			;
		}

		try {
			t.setProducer("");
			Assert.fail("setProducer accepts EmptyString");
		} catch (Exception var4) {
			;
		}

		try {
			t.setProducer((String) null);
			Assert.fail("setProducer accepts null");
		} catch (Exception var3) {
			;
		}

	}

	@Test
	public void _314testInfoVehicle_mark3() throws Exception {
		Plane t = new Plane();
		t.setProducer("prod");
		Assert.assertEquals("prod", t.infoVehicle());
		t.setProducer("prod1");
		Assert.assertEquals("prod1", t.infoVehicle());
		t.setProducer("prod2");
		Assert.assertEquals("prod2", t.infoVehicle());
	}

	@Test
	public void _315testSetPrice_mark3() throws Exception {
		Plane t = new Plane();
		t.setPrice(3.5D);
		Assert.assertEquals(3.5D, t.getPrice(), 0.1D);
		t.setPrice(5.0D);
		Assert.assertEquals(5.0D, t.getPrice(), 0.1D);
		t.setPrice(8.2D);
		Assert.assertEquals(8.2D, t.getPrice(), 0.1D);
	}

	@Test
	public void _316testSetPriceException_mark3() {
		Plane t = new Plane();

		try {
			t.setPrice(0.0D);
			Assert.fail("setPrice accepts 0 - it must NOT");
		} catch (Exception var4) {
			;
		}

		try {
			t.setPrice(-5.0D);
			Assert.fail("setPrice accepts negative values - it MUST NOT");
		} catch (Exception var3) {
			;
		}

	}

	@Test
	public void _317testClone_mark3() throws Exception {
		Plane t1 = new Plane();
		t1.setProducer("P1");
		Plane t2 = (Plane) t1.clone();
		t2.setProducer(new String("P1"));
		Assert.assertNotSame(t1, t2);
		if (t1.getWeight() != t2.getWeight()) {
			Assert.fail("clone not correct implemented");
		}

		if (t1.getPrice() != t2.getPrice()) {
			Assert.fail("clone not correct implemented");
		}

		if (t1.getProducer() == t2.getProducer() || t1.getProducer().compareTo(t2.getProducer()) != 0) {
			Assert.fail("clone not correct implemented");
		}

	}

	@Test
	public void _317testCloneIC_mark3() throws Exception {
		Float[] fa = new Float[] { new Float(11.0F), new Float(12.0F) };
		PlaneCargo pc1 = new PlaneCargo(1720.3F, 270001.9D, "Airbus", 9.0F, fa);
		for (int i = 0; i < pc1.getPackagesWeight().length; i++) {
			System.out.println(pc1.getPackagesWeight()[i]);
		}
		PlaneCargo pc2 = (PlaneCargo) pc1.clone();
		Assert.assertNotSame(pc1, pc2);
		if (pc1.getWeight() != pc2.getWeight()) {
			Assert.fail("clone not correct implemented");
		}

		if (pc1.getPrice() != pc2.getPrice()) {
			Assert.fail("clone not correct implemented");
		}
		System.out.println(pc1.getProducer() + "----" + pc2.getProducer());
		if (pc1.getProducer() == pc2.getProducer() || pc1.getProducer().compareTo(pc2.getProducer()) != 0) {
			Assert.fail("clone not correct implemented");
		}

		Float[] pcw1 = pc1.getPackagesWeight();
		Float[] pcw2 = pc2.getPackagesWeight();
		for (int i = 0; i < pcw1.length; ++i) {
			if (pcw1[i] == pcw2[i] || !pcw1[i].equals(pcw2[i])) {
				Assert.fail("clone not correct implemented");
			}
		}

	}

	@Test
	public void _318testSetFieldInInh_mark3() throws Exception {
		PlaneCargo t = new PlaneCargo();
		t.setCapacity(3.0F);
		Assert.assertEquals(3.0D, (double) t.getCapacity(), 0.1D);
		t.setCapacity(5.0F);
		Assert.assertEquals(5.0D, (double) t.getCapacity(), 0.1D);
		t.setCapacity(8.0F);
		Assert.assertEquals(8.0D, (double) t.getCapacity(), 0.1D);
	}

	@Test
	public void _319testSetFieldInInhException_mark3() {
		PlaneCargo t = new PlaneCargo();

		try {
			t.setCapacity(0.0F);
			Assert.fail("setCapacity accepts 0 - it MUST NOT");
		} catch (Exception var4) {
			;
		}

		try {
			t.setCapacity(-5.0F);
			Assert.fail("setCapacity accepts negative values - it MUST NOT");
		} catch (Exception var3) {
			;
		}

	}

	@Test
	public void _320testInfoInhClass_mark3() throws Exception {
		PlaneCargo t = new PlaneCargo();
		t.setCapacity(5.0F);
		System.out.println("t cap = " + t.infoVehicle());
		Assert.assertEquals("5.0", t.infoVehicle());
		t.setCapacity(7.0F);
		Assert.assertEquals("7.0", t.infoVehicle());
		t.setCapacity(20.0F);
		Assert.assertEquals("20.0", t.infoVehicle());
	}

   @Test
   public void _410testDAO_Mark4() {
      String dbF = "test1.db";

      try {
         Connection c = null;
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:" + dbF);
         c.setAutoCommit(false);
         Statement stmt = c.createStatement();
         String sqlCreateTable = "create table PLANES(ID INT PRIMARY KEY NOT NULL,PRODUCER TEXT NOT NULL,PRICE REAL, WEIGHT REAL)";
         stmt.executeUpdate(sqlCreateTable);
         stmt.close();
         c.commit();
         PlaneDAO.setConnection(dbF);
         Plane p1 = new Plane(12000.5F, 700000.8D, "Airbus A310");
         Plane p2 = new Plane(14500.5F, 825000.9D, "Boehing 710");
         PlaneDAO.saveDataInDb(1, p1);
         PlaneDAO.saveDataInDb(2, p2);
         String dbStr = PlaneDAO.selectData();
         PlaneDAO.closeConnection();
         stmt = c.createStatement();
         String sqlSelect = "select * from PLANES";
         StringBuffer sb = new StringBuffer();
         ResultSet rs = stmt.executeQuery(sqlSelect);

         while(rs.next()) {
            int id = rs.getInt("id");
            String producer = rs.getString("PRODUCER");
            float price = rs.getFloat("PRICE");
            float weight = rs.getFloat("WEIGHT");
            sb.append(id + ":" + producer + ":" + price + ":" + weight + "\r\n");
         }

         stmt.close();
         c.close();
         String dbStrResult = sb.toString();
         System.out.println("dbResult = \n" + dbStrResult);
         Assert.assertEquals(dbStrResult, dbStr);
      } catch (Exception var19) {
         Assert.fail("JDBC - Connectivity/protocol isn't correct");
      } finally {
         File f = new File(dbF);
         if (f.exists()) {
            f.delete();
         }

      }

   }

   @Test
   public void _411testDAO_Mark4() {
      String dbF = "test2.db";

      try {
         Connection c = null;
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:" + dbF);
         c.setAutoCommit(false);
         Statement stmt = c.createStatement();
         String sqlCreateTable = "create table PLANES(ID INT PRIMARY KEY NOT NULL,PRODUCER TEXT NOT NULL,PRICE REAL, WEIGHT REAL)";
         stmt.executeUpdate(sqlCreateTable);
         stmt.close();
         c.commit();
         PlaneDAO.setConnection(dbF);
         Plane p1 = new Plane(12000.5F, 700000.8D, "Airbus A310");
         Plane p2 = new Plane(14500.5F, 825000.9D, "Boehing 710");
         Plane p3 = new Plane(12000.5F, 600000.8D, "Airbus A310");
         PlaneDAO.saveDataInDb(1, p1);
         PlaneDAO.saveDataInDb(2, p2);
         PlaneDAO.saveDataInDb(3, p3);
         double priceT = 700000.0D;
         String dbStr = PlaneDAO.selectData(priceT);
         PlaneDAO.closeConnection();
         stmt = c.createStatement();
         String sqlSelect = "select * from PLANES where PRICE > " + priceT;
         StringBuffer sb = new StringBuffer();
         ResultSet rs = stmt.executeQuery(sqlSelect);

         while(rs.next()) {
            int id = rs.getInt("id");
            String producer = rs.getString("PRODUCER");
            float price = rs.getFloat("PRICE");
            float weight = rs.getFloat("WEIGHT");
            sb.append(id + ":" + producer + ":" + price + ":" + weight + "\r\n");
         }

         stmt.close();
         c.close();
         String dbStrResult = sb.toString();
         System.out.println("dbResult = \n" + dbStrResult);
         Assert.assertEquals(dbStrResult, dbStr);
      } catch (Exception var22) {
         Assert.fail("JDBC - Connectivity/protocol isn't correct");
      } finally {
         File f = new File(dbF);
         if (f.exists()) {
            f.delete();
         }

      }

   }

   @Test
   public void _510testThreads_mark5() throws ClassNotFoundException {
      String dbF = "test3.db";
      Connection c = null;

      try {
         Class.forName("org.sqlite.JDBC");
      } catch (ClassNotFoundException var28) {
         var28.printStackTrace();
      }

      List<Vehicle> ls = null;
      ArrayList lr = null;

      try {
         c = DriverManager.getConnection("jdbc:sqlite:" + dbF);
         c.setAutoCommit(false);
         Statement stmt = c.createStatement();
         String sqlCreateTable = "create table PLANES(ID INT PRIMARY KEY NOT NULL,PRODUCER TEXT NOT NULL,PRICE REAL, WEIGHT REAL)";
         stmt.executeUpdate(sqlCreateTable);
         stmt.close();
         c.commit();
         lr = new ArrayList();
         PlaneDAO.setConnection(dbF);
         Plane p1 = null;
         Plane p2 = null;
         Plane p3 = null;

         try {
            p1 = new Plane(12000.0F, 700000.8D, "Airbus A310");
            p2 = new Plane(14000.0F, 825000.9D, "Boehing 710");
            p3 = new Plane(16000.0F, 600000.8D, "Airbus A310");
         } catch (Exception var27) {
            var27.printStackTrace();
         }

         PlaneDAO.saveDataInDb(1, p1);
         PlaneDAO.saveDataInDb(2, p2);
         PlaneDAO.saveDataInDb(3, p3);
         lr.add(p1);
         lr.add(p2);
         lr.add(p3);
         ls = PlaneDAO.selectDataIntoList();
         PlaneDAO.closeConnection();
         if (ls != null && lr != null) {
            double avgW1 = 0.0D;
            double avgW2 = 0.0D;

            for(int idx = 0; idx < ls.size(); ++idx) {
               Vehicle v1 = (Vehicle)ls.get(idx);
               Vehicle v2 = (Vehicle)lr.get(idx);
               avgW1 += (double)((Plane)v1).getWeight();
               avgW2 += (double)((Plane)v2).getWeight();
            }

            avgW1 /= (double)ls.size();
            avgW2 /= (double)lr.size();
            VectThread vt = new VectThread(dbF);
            Thread t = new Thread(vt);
            t.start();

            try {
               t.join();
            } catch (InterruptedException var26) {
               var26.printStackTrace();
            }

            double avgW3 = vt.getAvgWeight();
            Assert.assertEquals((long)ls.size(), 3L);
            Assert.assertEquals((long)lr.size(), 3L);
            Assert.assertEquals(avgW1, avgW2, 0.001D);
            Assert.assertEquals(avgW1, avgW3, 0.001D);
            Assert.assertEquals(avgW2, avgW3, 0.001D);
         } else {
            Assert.fail("Multithreading class mark 5 isn't correct");
         }
      } catch (SQLException var29) {
         var29.printStackTrace();
      } finally {
         File f = new File(dbF);
         if (f.exists()) {
            f.delete();
         }

      }

   }

   @Test
   public void _610testCreateList_mark6() throws Exception {
      ArrayList lista = (ArrayList)PlaneUtils.createList(6);

      try {
         Assert.assertEquals(6L, (long)lista.size());
      } catch (Exception var4) {
         Assert.fail("createPlanes() method returns null");
      }

      lista = (ArrayList)PlaneUtils.createList(10);

      try {
         Assert.assertEquals(10L, (long)lista.size());
      } catch (Exception var3) {
         Assert.fail("createPlanes() method returns null");
      }

   }

   @Test
   public void _611testCreateListException_mark6() {
      ArrayList lista;
      try {
         lista = (ArrayList)PlaneUtils.createList(0);
         if (lista != null) {
            Assert.fail("It has been created a list with 0 items - it MUST NOT");
         }
      } catch (Exception var3) {
         ;
      }

      try {
         lista = (ArrayList)PlaneUtils.createList(-3);
         if (lista != null) {
            Assert.fail("It has been created a list with negative number of items - it MUST NOT");
         }
      } catch (Exception var2) {
         ;
      }

   }

   @Test
   public void _612testReadList_mark6() throws Exception {
      ArrayList lista = (ArrayList)PlaneUtils.readListFromFile("planesList.txt");

      try {
         Assert.assertEquals(3L, (long)lista.size());
      } catch (Exception var3) {
         Assert.fail("It must be 3 items into the file.");
      }

      Plane t = (Plane)lista.get(0);
      Assert.assertEquals("Airbus 310", t.getProducer());
      Assert.assertEquals(700000.0D, t.getPrice(), 0.1D);
      Assert.assertEquals(21000.0D, (double)t.getWeight(), 0.1D);
      t = (Plane)lista.get(1);
      Assert.assertEquals("Airbus 300", t.getProducer());
      Assert.assertEquals(600000.0D, t.getPrice(), 0.1D);
      Assert.assertEquals(18500.0D, (double)t.getWeight(), 0.1D);
      t = (Plane)lista.get(2);
      Assert.assertEquals("Boeing 710", t.getProducer());
      Assert.assertEquals(150000.0D, t.getPrice(), 0.1D);
      Assert.assertEquals(14500.0D, (double)t.getWeight(), 0.1D);
   }

   @Test
   public void _613testReadException_mark6() {
      try {
    	  System.out.println("Testam aici!");
         ArrayList<Vehicle> lista = (ArrayList)PlaneUtils.readListFromFile("tttt.ttt");
         if (lista != null) {
            Assert.fail("IT must not be read from an inexisting file");
         }
      } catch (Exception var2) {
         ;
      }

   }

   @Test
   public void _614testBinary_mark6() throws Exception {
      ArrayList<Vehicle> lista = (ArrayList)PlaneUtils.createList(3);
      if (lista != null) {
         for(int i = 0; i < lista.size(); ++i) {
            Plane t = (Plane)lista.get(i);
            t.setPrice((double)(i + 1));
            t.setProducer("Prod" + i);
            t.setWeight((float)(i + 101));
         }

         PlaneUtils.writeBinary("f.dat", lista);
         ArrayList<Vehicle> lista2 = (ArrayList)PlaneUtils.readBinary("f.dat");
         File f = new File("f.dat");
         if (f.exists()) {
            f.delete();
         }

         Assert.assertEquals((long)lista2.size(), 3L);
         Assert.assertNotSame(lista, lista2);

         for(int idx = 0; idx < lista.size(); ++idx) {
            Vehicle p1 = (Vehicle)lista.get(idx);
            Vehicle p2 = (Vehicle)lista2.get(idx);
            if (p1 == p2 || !p1.equals(p2)) {
               Assert.fail("createPlanes / writeBinaryPlanes / readBinaryPlanes related to clone/equals aren't correct");
            }
         }
      } else {
         Assert.fail("createPlanes / writeBinaryPlanes / readBinaryPlanes aren't correct");
      }

   }

   @Test
   public void _615testThreads_mark6() throws Exception {
      ArrayList<Vehicle> lista = (ArrayList)PlaneUtils.createList(3);
      if (lista != null) {
         for(int i = 0; i < lista.size(); ++i) {
            Plane t = (Plane)lista.get(i);
            t.setPrice((double)(i + 1));
            t.setProducer("Prod" + i);
            t.setWeight((float)(i + 102));
         }

         PlaneUtils.writeBinary("f.dat", lista);
         ArrayList<Vehicle> lista2 = (ArrayList)PlaneUtils.readBinary("f.dat");
         double avgW1 = 0.0D;

         for(int idx = 0; idx < lista2.size(); ++idx) {
            Vehicle p2 = (Vehicle)lista2.get(idx);
            avgW1 += (double)((Plane)p2).getWeight();
         }

         avgW1 /= (double)lista2.size();
         File f = new File("f.dat");
         VectThread vt = new VectThread(f);
         Thread t = new Thread(vt);
         t.start();
         t.join();
         double avgW2 = vt.getAvgWeight();
         if (f.exists()) {
            f.delete();
         }

         Assert.assertEquals((long)lista2.size(), 3L);
         Assert.assertEquals(avgW1, avgW2, 0.001D);
      } else {
         Assert.fail("Multithreading class mark 6 isn't correct");
      }

   }

   @Test
   public void _711testTCPServerMultiThread_Plus1or2EqMark7() {
      try {
         String fileName = "myf1.dat";
         List<Vehicle> list1 = (ArrayList)PlaneUtils.createList(3);
         if (list1 != null) {
            for(int i = 0; i < list1.size(); ++i) {
               Plane t = (Plane)list1.get(i);
               t.setPrice((double)(i + 1));
               t.setProducer("Prod" + i);
               t.setWeight((float)(i + 102));
            }

            PlaneUtils.writeBinary(fileName, list1);
            List<Vehicle> list2 = (ArrayList)PlaneUtils.readBinary(fileName);
            TCPServerSocketMultiT serv = new TCPServerSocketMultiT(50001);
            serv.setFileName(fileName);
            Runnable thS = () -> {
               try {
                  serv.startTCPServer();
               } catch (Exception var2) {
                  Assert.fail("TCP server class isn't correct");
               }

            };
            Thread tS = new Thread(thS);
            tS.start();
            Runnable thC = () -> {
               try {
                  Socket s = new Socket("127.0.0.1", serv.getPort());
                  PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                  ObjectInputStream in = new ObjectInputStream(s.getInputStream());
                  out.println("GETFILE");
                  List<Vehicle> list3 = (List)in.readObject();
                  Assert.assertEquals((long)list3.size(), 3L);

                  for(int idxx = 0; idxx < list3.size(); ++idxx) {
                     Vehicle p1 = (Vehicle)list2.get(idxx);
                     Vehicle p2 = (Vehicle)list3.get(idxx);
                     if (p1 == p2 || !p1.equals(p2)) {
                        Assert.fail("TCP Socket serialization isn't correct");
                     }
                  }

                  out.println("EXIT");
                  out.close();
                  s.close();
               } catch (Exception var9) {
                  Assert.fail("Connectivity/protocol to the TCP server class isn't correct");
               }

            };
            Thread tC = new Thread(thC);
            tC.start();
            tC.join();
            File f = new File(fileName);
            if (f.exists()) {
               f.delete();
            }
         }
      } catch (Exception var10) {
         Assert.fail("Connectivity/protocol to the TCP server class isn't correct");
      }

   }

   @Test
   public void _712testTCPServerMultiThread_Plus1or2EqMark7() {
      try {
         String fileName = "myf2.dat";
         List<Vehicle> list1 = (ArrayList)PlaneUtils.createList(3);
         if (list1 != null) {
            for(int i = 0; i < list1.size(); ++i) {
               Plane t = (Plane)list1.get(i);
               t.setPrice((double)(i + 1));
               t.setProducer("Prod" + i);
               t.setWeight((float)(i + 102));
            }

            PlaneUtils.writeBinary(fileName, list1);
            List<Vehicle> list2 = (ArrayList)PlaneUtils.readBinary(fileName);
            TCPServerSocketMultiT serv = new TCPServerSocketMultiT(50101);
            serv.setFileName(fileName);
            Runnable thS = () -> {
               try {
                  serv.startTCPServer();
               } catch (Exception var2) {
                  Assert.fail("TCP server class isn't correct");
               }

            };
            Thread tS = new Thread(thS);
            tS.start();
            Runnable thC = () -> {
               try {
                  Socket s = new Socket("127.0.0.1", serv.getPort());
                  PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                  ObjectInputStream in = new ObjectInputStream(s.getInputStream());
                  out.println("GETJSON");
                  String jsonIn = in.readUTF();
                  Assert.assertEquals((long)list2.size(), 3L);
                  JSONObject dataset = new JSONObject();
                  dataset.put("planes", new JSONArray());
                  JSONObject[] jsonarrays = new JSONObject[list2.size()];

                  for(int i = 0; i < list2.size(); ++i) {
                     jsonarrays[i] = new JSONObject();
                     Plane p = (Plane)list2.get(i);
                     jsonarrays[i].put("weight", (double)p.getWeight());
                     jsonarrays[i].put("price", p.getPrice());
                     jsonarrays[i].put("producer", p.getProducer());
                     dataset.append("planes", jsonarrays[i]);
                  }

                  String strJson = dataset.toString();
                  System.out.println("jsonIn = " + jsonIn);
                  out.println("EXIT");
                  out.close();
                  s.close();
                  Assert.assertEquals(strJson, jsonIn);
               } catch (Exception var10) {
                  Assert.fail("Connectivity/protocol to the TCP server class isn't correct");
               }

            };
            Thread tC = new Thread(thC);
            tC.start();
            tC.join();
            File f = new File(fileName);
            if (f.exists()) {
               f.delete();
            }
         }
      } catch (Exception var10) {
         Assert.fail("Connectivity/protocol to the TCP server class isn't correct");
      }

   }

   @Test
   public void _810testTCPServerMultiThreadDAO_Mark8() {
      String dbF = "test.db";

      try {
         Connection c = null;
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:" + dbF);

         c.setAutoCommit(false);
         Statement stmt = c.createStatement();
         String sqlCreateTable = "create table PLANES(ID INT PRIMARY KEY NOT NULL,PRODUCER TEXT NOT NULL,PRICE REAL, WEIGHT REAL)";
         stmt.executeUpdate(sqlCreateTable);

         stmt.close();
         c.commit();
         PlaneDAO.setConnection(dbF);

         Plane p1 = new Plane(12000.5F, 700000.8D, "Airbus A310");
         Plane p2 = new Plane(14500.5F, 800000.8D, "Boeing 500");
         PlaneDAO.saveDataInDb(1, p1);
         PlaneDAO.saveDataInDb(2, p2);
         String dbStr = PlaneDAO.selectData();
         PlaneDAO.closeConnection();
         stmt = c.createStatement();
         String sqlSelect = "select * from PLANES";
         StringBuffer sb = new StringBuffer();
         ResultSet rs = stmt.executeQuery(sqlSelect);
         while(rs.next()) {
            int id = rs.getInt("id");
            String producer = rs.getString("PRODUCER");
            float price = rs.getFloat("PRICE");
            float weight = rs.getFloat("WEIGHT");
            sb.append(id + ":" + producer + ":" + price + ":" + weight + "\r\n");
         }

         stmt.close();
         c.close();
         String dbStrResult = sb.toString();
         System.out.println("dbResult = \n" + dbStrResult);
         Assert.assertEquals(dbStrResult, dbStr);
         TCPServerSocketMultiT serv = new TCPServerSocketMultiT(50201);
         serv.setFileName(dbF);
         Runnable thS = () -> {
            try {
               serv.startTCPServer();
            } catch (Exception var2) {
               Assert.fail("TCP server class isn't correct");
            }

         };
         Thread tS = new Thread(thS);
         tS.start();
         Runnable thC = () -> {
            try {
               Socket s = new Socket("127.0.0.1", serv.getPort());
               PrintWriter out = new PrintWriter(s.getOutputStream(), true);
               ObjectInputStream in = new ObjectInputStream(s.getInputStream());
               out.println("GETDB");
               String dbStrC = in.readUTF();
               System.out.println("dbStrC = " + dbStrC);
               out.println("EXIT");
               out.close();
               s.close();
               Assert.assertEquals(dbStrResult, dbStrC);
            } catch (Exception var6) {
               Assert.fail("JDBC - Connectivity/protocol to the TCP server class isn't correct");
            }

         };
         Thread tC = new Thread(thC);
         tC.start();
         tC.join();
      } catch (Exception var21) {
         Assert.fail("JDBC - Connectivity/protocol to the TCP server class isn't correct");
      } finally {
         File f = new File(dbF);
         if (f.exists()) {
            f.delete();
         }

      }

   }

   @Test
   public void _910testUDPServerClientPlus1or2_EqMark9_10() throws Exception {
      Throwable var1 = null;
	 Object var2 = null;

	 try {
	    UDPServerSocket uss = new UDPServerSocket();

	    try {
	       UDPClientSocket ucs = new UDPClientSocket();

	       try {
	          Runnable th1 = () -> {
	             try {
	                uss.processRequest();
	             } catch (Exception var21) {
	                Assert.fail("UDP server class isn't correct");
	             }

	          };
	          Runnable[] thArr = new Runnable[]{() -> {
	             try {
	                String r1 = ucs.sendAndReceiveMsg("Q?", "127.0.0.1", uss.getBindPort());
	                System.out.println("r1 = " + r1);
	                Assert.assertEquals("UDPQ", r1);
	             } catch (Exception var3) {
	                Assert.fail("UDP client class isn't correct");
	             }

	          }, () -> {
	             try {
	                String r2 = ucs.sendAndReceiveMsg("TEST", "127.0.0.1", uss.getBindPort());
	                System.out.println("r2 = " + r2);
	                Assert.assertEquals("ACK", r2);
	             } catch (Exception var3) {
	                Assert.fail("UDP client class isn't correct");
	             }

	          }, () -> {
	             try {
	                String r3 = ucs.sendAndReceiveMsg("BYE", "127.0.0.1", uss.getBindPort());
	                System.out.println("r3 = " + r3);
	                Assert.assertEquals("BYE ACK", r3);
	             } catch (Exception var3) {
	                Assert.fail("UDP client class isn't correct");
	             }

	          }};
	          Thread[] tArr = new Thread[]{new Thread(thArr[0]), new Thread(thArr[1]), new Thread(thArr[2])};

	          for(int i = 0; i < tArr.length; ++i) {
	             Thread t1 = new Thread(th1);
	             t1.start();
	             tArr[i].start();
	             tArr[i].join();
	             t1.join();
	          }
	       } finally {
	          if (ucs != null) {
	             ucs.close();
	          }

	       }
	    } catch (Throwable var23) {
	       if (var1 == null) {
	          var1 = var23;
	       } else if (var1 != var23) {
	          var1.addSuppressed(var23);
	       }

	       if (uss != null) {
	          uss.close();
	       }

	       throw var1;
	    }

	    if (uss != null) {
	       uss.close();
	    }
	 } catch (Throwable var24) {
	    if (var1 == null) {
	       var1 = var24;
	    } else if (var1 != var24) {
	       var1.addSuppressed(var24);
	    }

	    try {
			throw var1;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

   }
}