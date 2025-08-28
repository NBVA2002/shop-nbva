package com.nbva.product.infrastructure.repository.impl;

import com.nbva.product.api.dto.product.request.PageProductRequest;
import com.nbva.product.domain.entity.ProductEntity;
import com.nbva.product.domain.entity.ProductEntity_;
import com.nbva.product.infrastructure.repository.JpaProductCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class JpaProductCustomRepositoryImpl implements JpaProductCustomRepository {
    private final EntityManager entityManager;

    @Override
    public Page<ProductEntity> getPageProduct(PageProductRequest pageProductRequest) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<ProductEntity> cq = cb.createQuery(ProductEntity.class);
        Root<ProductEntity> root = cq.from(ProductEntity.class);

        // where
        Predicate isDel = cb.isFalse(root.get(ProductEntity_.isDel));

        // Tạo query
        cq.select(root).where(isDel);
        TypedQuery<ProductEntity> query = entityManager.createQuery(cq);

        // Phân trang
        query.setFirstResult(pageProductRequest.getPageNumber() * pageProductRequest.getPageSize());   // offset
        query.setMaxResults(pageProductRequest.getPageSize());           // limit

        // Lấy dữ liệu
        List<ProductEntity> result = query.getResultList();

        // Query count
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<ProductEntity> countRoot = countQuery.from(ProductEntity.class);
        Predicate isDelCount = cb.isFalse(countRoot.get(ProductEntity_.isDel));
        countQuery.select(cb.count(countRoot)).where(isDelCount);

        Long totalElements = entityManager.createQuery(countQuery).getSingleResult();

        // Trả về Page
        return new PageImpl<>(result, pageProductRequest.toPageable(), totalElements);
    }

//    public Page<ProductEntity> hasStatus(Pageable pageable) {
//        // builder -> query -> from
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<ProductEntity> cq = cb.createQuery(ProductEntity.class);
//        Root<ProductEntity> root = cq.from(ProductEntity.class);
//
//        // join
//        Join<ProductEntity, Objects> categoryJoin = root.join("categoryId", JoinType.INNER);
//
//        // where
//        Predicate status = cb.equal(root.get(ProductEntity_.name), "ACTIVE");
//        Predicate categoryName = cb.equal(categoryJoin.get("name"), "ELECTRONICS");
//
//        // excute
//        cq.select(root).where(cb.and(status, categoryName));
//        List<ProductEntity> result = entityManager.createQuery(cq).getResultList();
//
//        return new PageImpl<>(result, pageable, result.size());
//    }
}
