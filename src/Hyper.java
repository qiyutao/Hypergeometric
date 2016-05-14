
public class Hyper {
	private int m_id;
	private int m_totality;
	private int m_scsInTotal;
	private int m_sample;
	private int m_scsInSmp;
	private double m_value;
	private String m_name;
	
	public Hyper()
	{
		m_totality = 1;
		m_scsInTotal = 1;
		m_sample = 1;
		m_scsInSmp = 1;
		m_value = 1;
		m_name = "";
	}

	public Hyper(int i,String n,int t, int st, int s, int ss)
	{
		m_id = i;
		m_name = n;
		m_totality = t;
		m_scsInTotal = st;
		m_sample = s;
		m_scsInSmp = ss;
		m_value = 1;
	}

	public int getID()
	{
		return m_id;
	}

	public int getTotal()
	{
		return m_totality;
	}

	public int getST()
	{
		return m_scsInTotal;
	}

	public int getSample()
	{
		return m_sample;
	}

	public int getSS()
	{
		return m_scsInSmp;
	}

	public String getName()
	{
		return m_name;
	}

	public double getValue()
	{
		return m_value;
	}

	public void setTotal(int t)
	{
		m_totality = t;
	}

	public void setST(int st)
	{
		m_scsInTotal = st;
	}

	public void setSample(int s)
	{
		m_sample = s;
	}

	public void setSS(int ss)
	{
		m_scsInSmp = ss;
	}

	public void calculate()
	{
		int scsInTotal, totality;
		int scsInSmp, sample;

		scsInTotal = m_scsInTotal;
		totality = m_totality;

		scsInSmp = m_scsInSmp;
		sample = m_sample;

		int n = scsInTotal;
		int tmp1 = scsInSmp;
		int tmp2 = sample;

		for (int i = 0; i<n; i++)
		{
			m_value *= (double)tmp2 / tmp1;
			m_value *= (double)scsInTotal / totality;
			totality--;
			scsInTotal--;
			tmp2--;
			tmp1--;
			if (tmp1 == 0)
			{
				tmp1 = m_scsInTotal - m_scsInSmp;
				tmp2 = m_totality - m_sample;
			}
		}
	}

	void display()
	{
		System.out.println("¼ÆËã½á¹û£º"+m_value);
	}

	void dis_cur()
	{
		System.out.println(m_name+"  ********  Ok");
	}

}
