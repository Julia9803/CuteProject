

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import PO.GoodsInSalePO;
import PO.PresentForSumPO;
import dataHelper.service.BasicUtil;
import dataHelper.service.CriterionClauseGenerator;
import dataHelper.serviceImpl.CriterionClause;
import dataHelper.serviceImpl.HibernateCriterionClauseGenerator;
import dataHelper.serviceImpl.HibernateUtil;
import util.PresentState;

/**     
* @author 李安迪
* @date 2017年12月29日
* @description
*/
public class HibernateCriterionClauseGeneratorTest {

	BasicUtil<PresentForSumPO> u = new HibernateUtil<PresentForSumPO>(PresentForSumPO.class);
	List<CriterionClause> l = new ArrayList<CriterionClause>();
	CriterionClauseGenerator c = new HibernateCriterionClauseGenerator();
	/**
	 * Test method for {@link dataHelper.HibernateCriterionClauseGenerator#generateGeCriterion(java.util.List, java.lang.String, java.lang.Object)}.
	 */
//	@Test
//	public final void testGenerateGeCriterion() {
//		
//	}
//
//	/**
//	 * Test method for {@link dataHelper.HibernateCriterionClauseGenerator#generateLeCriterion(java.util.List, java.lang.String, java.lang.Object)}.
//	 */
//	@Test
//	public final void testGenerateLeCriterion() {
//		
//	}
//
//	/**
//	 * Test method for {@link dataHelper.HibernateCriterionClauseGenerator#generateExactCriterion(java.util.List, java.lang.String, java.lang.Object)}.
//	 */
//	@Test
//	public final void testGenerateExactCriterionListOfCriterionClauseStringObject() {
//		
//	}
//
//	/**
//	 * Test method for {@link dataHelper.HibernateCriterionClauseGenerator#generateFuzzyCriterion(java.util.List, java.lang.String, java.lang.Object)}.
//	 */
//	@Test
//	public final void testGenerateFuzzyCriterion() {
//		
//	}

	/**
	 * Test method for {@link dataHelper.serviceImpl.HibernateCriterionClauseGenerator#generateCurrentTimeInRangeCriterion(java.util.List)}.
	 */
	@Test
	public final void testGenerateCurrentTimeInRangeCriterion() throws Exception{
		c.generateCurrentTimeInRangeCriterion(l);
	    @SuppressWarnings({ "unused"})
		GoodsInSalePO gpo = new GoodsInSalePO("1","abc",100);
	    List<GoodsInSalePO> gpolist = new ArrayList<>();
	    @SuppressWarnings("deprecation")
		PresentForSumPO po = new PresentForSumPO(1,Date.from(Instant.EPOCH), new Date(217,11,29),1, gpolist,PresentState.SAVE,1);
	    List<PresentForSumPO> ppo = new ArrayList<>();
	    ppo.add(po);
	    u.update(po);
		assertEquals(ppo,u.Query(l));
	}

//	/**
//	 * Test method for {@link dataHelper.HibernateCriterionClauseGenerator#generateExactCriterion(java.util.List, java.lang.String, java.util.List)}.
//	 */
//	@Test
//	public final void testGenerateExactCriterionListOfCriterionClauseStringList() {
//		
//	}
//
//	/**
//	 * Test method for {@link dataHelper.HibernateCriterionClauseGenerator#generateExactAsChildCriterion(java.util.List, java.lang.String, java.util.List)}.
//	 */
//	@Test
//	public final void testGenerateExactAsChildCriterion() {
//		
//	}

}
